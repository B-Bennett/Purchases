package com.theironyrad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

//import javax.persistence.*;


/**
 * Created by BennettIronYard on 11/11/15.
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue
    Integer id;

    String  name;
    String email;

    @OneToMany (mappedBy = "customer")
    List<Purchase> purchases;
}
