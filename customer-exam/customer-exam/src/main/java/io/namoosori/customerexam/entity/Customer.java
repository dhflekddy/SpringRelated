package io.namoosori.customerexam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Entity
@Table(name = "customer_tb")
@Getter@Setter
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private long registerDate;

    public Customer(String id, String name){
        this.id=id;
        this.name=name;
        this.registerDate=System.currentTimeMillis();
    }


    public static Customer sample(){
        return new Customer("ID0001","Kim");
    }
}
