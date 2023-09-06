package com.example.first.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@Entity
@Table(name="goods")
@NoArgsConstructor
@AllArgsConstructor
public class CProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="Type")
    private String prodType ;

    @Value("Tu frase aqui")
    @Column(name="Message")
    private String prodMessage;

    @Value("")
    @Column(name="Size")
    private String prodSize;

    @Value("White")
    @Column(name="Color")
    private String prodColor;

}
