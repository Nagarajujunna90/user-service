package com.emandi.customerservice.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Product {

    private Integer id;
    private String productDescription;
    private String name;

    private Date manufacturingDate;

    private String productCompany;

    

   /* @ManyToMany(mappedBy = "orders")
    private List<User> users;*/

}
