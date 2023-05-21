package com.bank.bankink.controller;

import com.bank.bankink.entity.Transaccion;
import com.bank.bankink.service.TransaccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransaccionController {

    /**
     * Referenciacion TransaccionService para ser usada en el controlador
     * */
    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    /**
     * Metodo post para realizar una compra si se tiene un saldo en la tarjeta
     * @param transaccionRequest
     * @return la transaccion que ha sido exitosa
     */
    @PostMapping("/purchase")
    public ResponseEntity<Transaccion> realizarCompra(@RequestBody Transaccion transaccionRequest) {
        Long tarjetaId = transaccionRequest.getTarjetaId();
        double monto = transaccionRequest.getMonto();

        Transaccion transaccion = transaccionService.realizarCompra(tarjetaId, monto);

        return ResponseEntity.ok(transaccion);
    }

    /**
     * Metodo get para consultar el id de una transaccion realizada
     * @param transactionId
     * @return la transaccion que se encontro
     */
    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaccion> consultarTransaccion(@PathVariable Long transactionId) {
        Transaccion transaccion = transaccionService.consultarTransaccion(transactionId);
        return ResponseEntity.ok(transaccion);
    }
}
