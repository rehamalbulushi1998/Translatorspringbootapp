package com.example.QuoteCRUD.controller;
import com.sun.istack.NotNull;
import com.example.QuoteCRUD.entity.Traslator;
import com.example.QuoteCRUD.service.TraslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/translator")
public class TranslatorController {
    private final TranslatorService translatorService;

    @Autowired
    public TranslatorController(TranslatorService translatorService) {
        this.translatorService = translatorService;
    }

    @PostMapping("/translateEnglishtoSpanish")
    public String translateEnglishtoSpanish(@RequestBody @NotNull String text) {
        return this.translatorService.translateEnglishtoSpanish(text);
    }

    @PostMapping("/translateSpanishtoEnglish")
    public String translateSpanishtoEnglish(@RequestBody @NotNull String text) {
        return this.translatorService.translateSpanishtoEnglish(text);
    }
}}