package com.trab4sistemas.controllers;

import com.trab4sistemas.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @PostMapping("/transferencia/lock-otimista")
    public void transferenciaLockOtimista(@RequestParam Long contaDebitoId, @RequestParam Long contaCreditoId, @RequestParam double valor) {
        contaService.transferenciaLockOtimista(contaDebitoId, contaCreditoId, valor);
    }

    @PostMapping("/transferencia/lock-pessimista")
    public void transferenciaLockPessimista(@RequestParam Long contaDebitoId, @RequestParam Long contaCreditoId, @RequestParam double valor) {
        contaService.transferenciaLockPessimista(contaDebitoId, contaCreditoId, valor);
    }
}
