package com.proiect_PS.resurse.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
public class ProductSuccesDTO {
    private String productName;
    private double productPrice;
    private Integer quantity;
    private LocalDateTime manufacturing;
    private LocalDateTime expiration;
    private double shipDeliveryPrice;
    private String companyName;

    private Long id;
}
