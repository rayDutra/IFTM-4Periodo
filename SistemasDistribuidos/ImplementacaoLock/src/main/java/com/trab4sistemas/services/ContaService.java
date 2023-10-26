package com.trab4sistemas.services;

import com.trab4sistemas.entitys.Conta;
import com.trab4sistemas.exception.SaldoInsuficienteException;
import com.trab4sistemas.repositories.ContaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void transferenciaLockOtimista(Long contaDebitoId, Long contaCreditoId, double valor) {
        Conta contaDebito = contaRepository.getOne(contaDebitoId);
        Conta contaCredito = contaRepository.getOne(contaCreditoId);

        if (contaDebito.getSaldo() >= valor) {
            contaDebito.setSaldo(contaDebito.getSaldo() - valor);
            contaCredito.setSaldo(contaCredito.getSaldo() + valor);

            contaRepository.save(contaDebito);
            contaRepository.save(contaCredito);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente na conta de débito.");
        }
    }

    @Transactional
    public void transferenciaLockPessimista(Long contaDebitoId, Long contaCreditoId, double valor) {

        Conta contaDebito = entityManager.find(Conta.class, contaDebitoId, LockModeType.PESSIMISTIC_WRITE);
        Conta contaCredito = entityManager.find(Conta.class, contaCreditoId, LockModeType.PESSIMISTIC_WRITE);


        if (contaDebito.getSaldo() >= valor) {
            contaDebito.setSaldo(contaDebito.getSaldo() - valor);
            contaCredito.setSaldo(contaCredito.getSaldo() + valor);


            entityManager.persist(contaDebito);
            entityManager.persist(contaCredito);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferência.");
        }
    }
}
