package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public Imovel criarImovel(@RequestBody Imovel imovel) {
        return imovelService.create(imovel);
    }

    @GetMapping
    public List<Imovel> listarImoveis() {
        return imovelService.findAll();
    }

    @GetMapping("/{id}")
    public Imovel buscarImovelPorId(@PathVariable String id) {
        return imovelService.findById(id);
    }

    @PutMapping("/{id}")
    public Imovel atualizarImovel(@PathVariable String id, @RequestBody Imovel imovel) {
        return imovelService.update(imovel);
    }

    @DeleteMapping("/{id}")
    public void deletarImovel(@PathVariable String id) {
        imovelService.delete(id);
    }
}
