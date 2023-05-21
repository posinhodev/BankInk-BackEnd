package com.bank.bankink.service;

import com.bank.bankink.entity.Tarjeta;
import com.bank.bankink.entity.Transaccion;
import com.bank.bankink.repository.TarjetaRepository;
import com.bank.bankink.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransaccionService {
    /**
     * Referenciacion de TarjetaRepository para ser usado en el servicio
     * */
    @Autowired
    public TarjetaRepository tarjetaRepository;
    /**
     * Referenciacion de TransaccionRepository para ser usado en el servicio
     * */
    private final TransaccionRepository transaccionRepository;
    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    /**
     * Metodo para realizar una compra si se tiene saldo en la tarjeta
     * @param tarjetaId
     * @param monto
     * @return la transaccion exitosa
     */
    public Transaccion realizarCompra(Long tarjetaId, double monto) {
        Tarjeta tarjeta = tarjetaRepository.findById(tarjetaId)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));

        if (!tarjeta.isActiva()) {
            throw new IllegalStateException("La tarjeta no está activa");
        }

        if (tarjeta.isBloqueada()) {
            throw new IllegalStateException("La tarjeta está bloqueada");
        }

        // Verificar que el saldo de la tarjeta sea suficiente para la compra
        if (tarjeta.getSaldo() < monto) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        Transaccion transaccion = new Transaccion();
        LocalDate fecha = LocalDate.now();

        transaccion.setTarjetaId(tarjetaId);
        transaccion.setMonto(monto);
        transaccion.setFecha(String.valueOf(fecha));
        tarjeta.setSaldo(tarjeta.getSaldo() - monto);

        tarjetaRepository.save(tarjeta);

        return transaccionRepository.save(transaccion);
    }

    /**
     * Metodo para consultar una transaccion exitosa
     * @param transactionId
     * @return no se tiene esa transaccion registrada
     */
    public Transaccion consultarTransaccion(Long transactionId) {
        return transaccionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transacción no encontrada"));
    }
}
