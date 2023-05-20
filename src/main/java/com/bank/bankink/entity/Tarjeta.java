package com.bank.bankink.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tarjeta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaVencimiento;
    private boolean activa;
    private boolean bloqueada;
    private double saldo;
}
