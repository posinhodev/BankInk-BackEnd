package com.bank.bankink.controller;

import com.bank.bankink.entity.Transaccion;
import com.bank.bankink.service.TransaccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransaccionController {
    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<Transaccion> realizarCompra(@RequestParam Long tarjetaId, @RequestParam double monto) {
        Transaccion transaccion = transaccionService.realizarCompra(tarjetaId, monto);
        return ResponseEntity.ok(transaccion);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaccion> consultarTransaccion(@PathVariable Long transactionId) {
        Transaccion transaccion = transaccionService.consultarTransaccion(transactionId);
        return ResponseEntity.ok(transaccion);
    }
}
