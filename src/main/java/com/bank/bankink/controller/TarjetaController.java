package com.bank.bankink.controller;

import com.bank.bankink.entity.Tarjeta;
import com.bank.bankink.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class TarjetaController {
    private final TarjetaService tarjetaService;

    public TarjetaController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    @GetMapping("/{productId}/number")
    public ResponseEntity<Tarjeta> generarNumeroTarjeta(@PathVariable Long productId) {
        Tarjeta tarjeta = tarjetaService.generarNumeroTarjeta(productId);
        return ResponseEntity.ok(tarjeta);
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> activarTarjeta(@RequestParam Long cardId) {
        tarjetaService.activarTarjeta(cardId);
        return ResponseEntity.ok("Tarjeta activada exitosamente");
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<String> bloquearTarjeta(@PathVariable Long cardId) {
        tarjetaService.bloquearTarjeta(cardId);
        return ResponseEntity.ok("Tarjeta bloqueada exitosamente");
    }

    @PostMapping("/balance")
    public ResponseEntity<String> recargarSaldo(@RequestParam Long cardId, @RequestParam double monto) {
        tarjetaService.recargarSaldo(cardId, monto);
        return ResponseEntity.ok("Saldo recargado exitosamente");
    }

    @GetMapping("/balance/{cardId}")
    public ResponseEntity<Double> consultarSaldo(@PathVariable Long cardId) {
        double saldo = tarjetaService.consultarSaldo(cardId);
        return ResponseEntity.ok(saldo);
    }
}
