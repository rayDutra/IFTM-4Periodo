package com.iftm.cassandra;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository repository;

    public ResponseEntity<List<Imovel>> findAll() {
        var imoveis = repository.findAll();
        if(imoveis.isEmpty())
                return ResponseEntity.notFound().build();
        return ResponseEntity.ok(imoveis) ;
    }
    public ResponseEntity<Imovel> findById(UUID id) {
       var imoveis = repository.findById(id);
       if (imoveis.isEmpty())
           return ResponseEntity.notFound().build();
        return ResponseEntity.ok(imoveis.get());
    }

    public ResponseEntity<Imovel> create(Imovel imovel) {
            return ResponseEntity.ok(repository.save(imovel));
    }


    public ResponseEntity<Imovel> update(UUID id, Imovel imovel) {
        if(imovel.getId() == null)
            return  ResponseEntity.badRequest().build();
        var dbImovel = repository.findById(imovel.getId());
        if(dbImovel.isEmpty())
            return ResponseEntity.badRequest().build();
        var curImovel = dbImovel.get();
        curImovel.setEndereco(imovel.getEndereco());
        curImovel.setTipoImovel(imovel.getTipoImovel());
        curImovel.setArea(imovel.getArea());
        curImovel.setPreco(imovel.getPreco());
        return ResponseEntity.ok(repository.save(curImovel));
    }

    public ResponseEntity<Imovel> delete(UUID id) {
        repository.deleteById(id);
        if(repository.existsById(id))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.noContent().build();
    }
}