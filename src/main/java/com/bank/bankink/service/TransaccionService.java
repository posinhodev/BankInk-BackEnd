package com.bank.bankink.service;

import com.bank.bankink.entity.Transaccion;
import com.bank.bankink.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {
    private final TransaccionRepository transaccionRepository;

    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public Transaccion realizarCompra(Long tarjetaId, double monto) {
        // Implementa la lógica para realizar la transacción de compra y generar el identificador.
        Transaccion transaccion = new Transaccion();
        transaccion.setTarjetaId(tarjetaId);
        transaccion.setMonto(monto);
        return transaccionRepository.save(transaccion);
    }

    public Transaccion consultarTransaccion(Long transactionId) {
        return transaccionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transacción no encontrada"));
    }
}
