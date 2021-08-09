package com.proiect_PS.resurse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCredentialsDTO {
    @Size(min=2,max=500)
    private String productName;
    @Min(0)
    private double productPrice;
    @Min(1)
    private Integer quantity;
    @Past
    private LocalDateTime manufacturing;
    @Future
    private LocalDateTime expiration;
    @PositiveOrZero
    private double shipDeliveryPrice;
    @Size(min=2,max=500)
    private String companyName;
    private Long id;

}
