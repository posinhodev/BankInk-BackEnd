package com.bank.bankink.service;

import com.bank.bankink.entity.Tarjeta;
import com.bank.bankink.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class TarjetaService {
    private final TarjetaRepository tarjetaRepository;

    public TarjetaService(TarjetaRepository tarjetaRepository) {
        this.tarjetaRepository = tarjetaRepository;
    }

    public Tarjeta generarNumeroTarjeta(Long productId) {
        // Implementa la lógica para generar el número de tarjeta a partir del productId y otros requerimientos.
        String numeroTarjeta = "1234567890123456"; // Ejemplo: número de tarjeta ficticio
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setProductId(productId);
        tarjeta.setNumeroTarjeta(numeroTarjeta);
        return tarjetaRepository.save(tarjeta);
    }

    public void activarTarjeta(Long cardId) {
        Tarjeta tarjeta = tarjetaRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
        tarjeta.setActiva(true);
        tarjetaRepository.save(tarjeta);
    }

    public void bloquearTarjeta(Long cardId) {
        Tarjeta tarjeta = tarjetaRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
        tarjeta.setBloqueada(true);
        tarjetaRepository.save(tarjeta);
    }

    public void recargarSaldo(Long cardId, double monto) {
        Tarjeta tarjeta = tarjetaRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
        tarjeta.setSaldo(tarjeta.getSaldo() + monto);
        tarjetaRepository.save(tarjeta);
    }

    public double consultarSaldo(Long cardId) {
        Tarjeta tarjeta = tarjetaRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
        return tarjeta.getSaldo();
    }
}
