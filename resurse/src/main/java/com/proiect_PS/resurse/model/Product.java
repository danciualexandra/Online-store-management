package com.proiect_PS.resurse.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
@XmlTransient
@ManyToOne(fetch=FetchType.EAGER)
Customer c;











}
