package com.proiect_PS.resurse.repository;

import com.proiect_PS.resurse.model.DiscountVoucher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends CrudRepository<DiscountVoucher,Long> {
    DiscountVoucher findFirstByVoucherCode(String code);
}
