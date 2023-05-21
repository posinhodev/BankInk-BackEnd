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
    /**
     * Referenciacion de TarjetaRepository para ser usado en el servicio
     * */
    private final TarjetaRepository tarjetaRepository;
    public TarjetaService(TarjetaRepository tarjetaRepository) {
        this.tarjetaRepository = tarjetaRepository;
    }

    /**
     * Meotodo para generar una nueva tarjeta
     * @param productId
     * @param nombreTitular
     * @return el numero nuevo de la tarjeta y el nombre del titular
     */
    public Tarjeta generarNumeroTarjeta(Long productId, String nombreTitular) {
        Tarjeta tarjeta = new Tarjeta();

        String digitosFijos = String.format("%06d", productId);
        String digitosAleatorios = generarDigitosAleatorios(10);
        String numeroTarjeta = digitosFijos + digitosAleatorios;

        tarjeta.setNumeroTarjeta(numeroTarjeta);
        tarjeta.setNombreTitular(nombreTitular);

        return tarjetaRepository.save(tarjeta);
    }

    /**
     * Metodo para generar los 10 digitos adicionales de la tarjeta
     * @param numDigitos
     * @return 10 digitos random
     */
    private String generarDigitosAleatorios(int numDigitos) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numDigitos; i++) {
            int digito = random.nextInt(10);
            sb.append(digito);
        }

        return sb.toString();
    }

    /**
     * Metodo para activar una tarjeta
     * @param cardId
     */
    public void activarTarjeta(Long cardId) {
        Tarjeta tarjeta = tarjetaRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
        LocalDate fechaVencimiento = LocalDate.now().plusYears(3);
        tarjeta.setFechaVencimiento(String.valueOf(fechaVencimiento));
        tarjeta.setActiva(true);
        tarjetaRepository.save(tarjeta);
    }

    /**
     * Metodo para bloquear una tarjeta ya activa
     * @param cardId
     */
    public void bloquearTarjeta(Long cardId) {
        Tarjeta tarjeta = tarjetaRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
        tarjeta.setBloqueada(true);
        tarjetaRepository.save(tarjeta);
    }

    /**
     * Metodo para recargar salgo a una tarjeta
     * @param cardId
     * @param monto
     */
    public void recargarSaldo(Long cardId, double monto) {
        Tarjeta tarjeta = tarjetaRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
        tarjeta.setSaldo(tarjeta.getSaldo() + monto);
        tarjetaRepository.save(tarjeta);
    }

    /**
     * Metodo para consultar el saldo
     * @param cardId
     * @return saldo de la tarjeta que se busco
     */
    public double consultarSaldo(Long cardId) {
        Tarjeta tarjeta = tarjetaRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
        return tarjeta.getSaldo();
    }
}
