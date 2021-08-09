package com.proiect_PS.resurse.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Customer extends User{

    private Integer zipcode;
    @OneToMany(fetch=FetchType.EAGER,orphanRemoval = true,cascade = {CascadeType.REMOVE,CascadeType.MERGE},mappedBy = "c")

    @XmlTransient
    private List<Product> products;
    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Account account;
    @OneToMany
    private List<DiscountVoucher> discounts;

    @Builder
    public Customer(Long id,String userName,String password, String firstName, String lastName,String email,String address, String phone,String gender,Integer zipcode,List<Product> products,Account account) {
        super(id, userName,password,firstName,lastName,email, address, phone,gender);
        this.zipcode=zipcode;
        this.products=products;
        this.account=account;


    }

}
