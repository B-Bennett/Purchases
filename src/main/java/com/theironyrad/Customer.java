package com.theironyrad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
