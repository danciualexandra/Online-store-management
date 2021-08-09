package com.proiect_PS.resurse.service.impl;

import com.proiect_PS.resurse.model.DiscountVoucher;
import com.proiect_PS.resurse.repository.DiscountRepository;
import com.proiect_PS.resurse.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl  implements DiscountService {
    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public DiscountVoucher findByCode(String voucherCode) {
        return discountRepository.findFirstByVoucherCode(voucherCode);
    }
    public List <DiscountVoucher> getAllVouchers(){
        return (List<DiscountVoucher>) discountRepository.findAll();
    }


}
