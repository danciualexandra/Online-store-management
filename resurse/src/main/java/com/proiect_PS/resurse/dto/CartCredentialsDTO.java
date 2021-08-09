package com.proiect_PS.resurse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartCredentialsDTO {
    @NotNull
    private List<String>  idProductsFromCart;
    Long id;
    @Positive
    String sum;
    String iban;
    String voucher;
}
