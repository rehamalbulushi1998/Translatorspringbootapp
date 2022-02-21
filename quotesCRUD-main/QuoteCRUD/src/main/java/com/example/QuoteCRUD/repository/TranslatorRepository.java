package com.example.QuoteCRUD.repository;


import com.example.QuoteCRUD.entity.Translator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Translator,Integer> {

}