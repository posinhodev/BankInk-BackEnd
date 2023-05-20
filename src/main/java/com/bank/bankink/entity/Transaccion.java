package com.bank.bankink.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transaccion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tarjetaId;
    private double monto;
    private String fecha;
}
