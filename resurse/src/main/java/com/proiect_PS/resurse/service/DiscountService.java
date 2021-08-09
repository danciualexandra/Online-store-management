package com.proiect_PS.resurse.service;

import com.proiect_PS.resurse.model.DiscountVoucher;
import com.proiect_PS.resurse.model.Product;
import org.springframework.stereotype.Component;

@Component
public interface DiscountService {
    DiscountVoucher findByCode(String voucherCode);
    Iterable<DiscountVoucher> getAllVouchers();
}
