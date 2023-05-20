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
        Tarjeta tarjeta = new Tarjeta();

        String digitosFijos = String.format("%06d", productId);

        String digitosAleatorios = generarDigitosAleatorios(10);

        String numeroTarjeta = digitosFijos + digitosAleatorios;

        tarjeta.setNumeroTarjeta(numeroTarjeta);

        return tarjetaRepository.save(tarjeta);
    }

    private String generarDigitosAleatorios(int numDigitos) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numDigitos; i++) {
            int digito = random.nextInt(10);
            sb.append(digito);
        }

        return sb.toString();
    }

    public void activarTarjeta(Long cardId) {
        Tarjeta tarjeta = tarjetaRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
        LocalDate fechaVencimiento = LocalDate.now().plusYears(3);
        tarjeta.setFechaVencimiento(String.valueOf(fechaVencimiento));
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
