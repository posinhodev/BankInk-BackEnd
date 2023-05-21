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
    /**
     * Referenciacion de TarjetaService para ser usado en el controlador
     */
    private final TarjetaService tarjetaService;

    public TarjetaController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    /**
     * Metodo get para generar un nuevo numero para una tarjeta
     * @param productId
     * @param tarjeta
     * @return la tarjeta que se genero exitosamente
     */
    @GetMapping("/{productId}/number")
    public ResponseEntity<Tarjeta> generarNumeroTarjeta(@PathVariable Long productId, @RequestBody Tarjeta tarjeta  ) {
        Tarjeta tarjetaGenerada = tarjetaService.generarNumeroTarjeta(productId, tarjeta.getNombreTitular());
        return ResponseEntity.ok(tarjetaGenerada);
    }

    /**
     * Metodo post para activar la tarjeta y la fecha de vencimiento
     * @param cardId
     * @return la tarjeta se activa
     */
    @PostMapping("/enroll")
    public ResponseEntity<String> activarTarjeta(@RequestParam Long cardId) {
        tarjetaService.activarTarjeta(cardId);
        return ResponseEntity.ok("Tarjeta activada exitosamente");
    }

    /**
     * Metodo delete para bloquear la tarjeta
     * @param cardId
     * @return la tarjeta bloqueada
     */
    @DeleteMapping("/{cardId}")
    public ResponseEntity<String> bloquearTarjeta(@PathVariable Long cardId) {
        tarjetaService.bloquearTarjeta(cardId);
        return ResponseEntity.ok("Tarjeta bloqueada exitosamente");
    }

    /**
     * Metodo post para agregar saldo saldo a la tarjeta
     * @param cardId
     * @param monto
     * @return
     */
    @PostMapping("/balance")
    public ResponseEntity<String> recargarSaldo(@RequestParam Long cardId, @RequestParam double monto) {
        tarjetaService.recargarSaldo(cardId, monto);
        return ResponseEntity.ok("Saldo recargado exitosamente");
    }

    /**
     * Metodo get para obtener el saldo de la tarjeta consultada
     * @param cardId
     * @return la el saldo de la tarjeta
     */
    @GetMapping("/balance/{cardId}")
    public ResponseEntity<Double> consultarSaldo(@PathVariable Long cardId) {
        double saldo = tarjetaService.consultarSaldo(cardId);
        return ResponseEntity.ok(saldo);
    }
}
