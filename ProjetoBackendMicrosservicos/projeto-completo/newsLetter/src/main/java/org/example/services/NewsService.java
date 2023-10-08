package org.example.services;
import com.logs.startexample.models.dtos.LogDTO;
import org.bson.types.ObjectId;
import org.example.models.dtos.NewsDTO;
import org.example.mensages.RabbitMqSendLog;
import org.example.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private RabbitMqSendLog rabbitMqSendLog;

    public ResponseEntity<List<NewsDTO>> findAll() {
        var dbNews = newsRepository.findAll();
        if(dbNews.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var dbNewsDTO = dbNews.stream().map(news -> new NewsDTO(news)).collect(Collectors.toList());
        return ResponseEntity.ok(dbNewsDTO);
    }

    public ResponseEntity<NewsDTO> findOne(ObjectId id){
        if(id == null)
            return ResponseEntity.badRequest().build();

        var dbNews = newsRepository.findById(String.valueOf(id));
        if(dbNews.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new NewsDTO(dbNews.get()));
    }

    public ResponseEntity<NewsDTO> save(NewsDTO newsDTO){
        if(newsDTO == null)
            return ResponseEntity.badRequest().build();
        System.out.println(newsDTO.convertToNews());
        var dbNews = newsRepository.save(newsDTO.convertToNews());

        rabbitMqSendLog.sendLog(new LogDTO("created", dbNews));
        return ResponseEntity.ok(new NewsDTO(dbNews));
    }

    public ResponseEntity<NewsDTO> update(NewsDTO newsDTO){
        if(newsDTO == null)
            return ResponseEntity.badRequest().build();

        var news = newsRepository.findById(String.valueOf(newsDTO.getId()));
        if(news.isEmpty())
            return ResponseEntity.notFound().build();

        var dbNews = newsRepository.save(newsDTO.convertToNews());

        rabbitMqSendLog.sendLog(new LogDTO<NewsDTO>("update", new NewsDTO(dbNews)));

        return ResponseEntity.ok(new NewsDTO(dbNews));
    }

    public ResponseEntity<?> delete(ObjectId id){
        if(id == null)
            return ResponseEntity.badRequest().build();

        var dbNews = newsRepository.findById(String.valueOf(id));

        if(dbNews.isEmpty())
            return ResponseEntity.notFound().build();

        newsRepository.delete(dbNews.get());

        rabbitMqSendLog.sendLog(new LogDTO<NewsDTO>("delete", new NewsDTO(dbNews.get())));

        return ResponseEntity.ok().build();
    }
}