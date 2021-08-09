package com.proiect_PS.resurse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscountVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String voucherCode;


}
