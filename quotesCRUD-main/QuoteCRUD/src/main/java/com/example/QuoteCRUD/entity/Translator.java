package com.example.QuoteCRUD.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Translation_TBL")
public class Translator {

    @Id
    @GeneratedValue
    private int id;
    private String text;
    private String texttranslated;
    private String sourcelanguage;
    private String targetlanguage;
    
}
