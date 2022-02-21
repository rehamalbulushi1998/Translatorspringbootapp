package com.example.QuoteCRUD.service;

import com.example.QuoteCRUD.entity.Translator;
import com.example.QuoteCRUD.repository.TranslatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslatorService {
    private final TranslatorRepository translatorRepository;
    private final String api_Url = "https://libretranslate.de/translate";

    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    public TranslatorService(TranslatorRepository translatorRepository) {
        this.translatorRepository = translatorRepository;
    }

    public String translateEnglishtoSpanish(String text) {
        try {
            TranslatorEntity translatedEntity = TranslatorEntity.builder()
                    .text(text)
                    .sourcelanguage("en")
                    .targetlanguage("es")
                    .build();
            return fetchTranslation(translatedEntity);
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    public String translateSpanishtoEnglish(String text) {
        try {
            TranslatorEntity translatedEntity = TranslatorEntity.builder()
                    .text(text)
                    .sourcelanguage("es")
                    .targetlanguage("en")
                    .build();
            return fetchTranslation(translatedEntity);
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    private String fetchTranslation(TranslatorEntity translatedEntity) {
        RestTemplate restTemplate = getRestTemplate();
        ResponseEntity<TranslatorEntity> response = restTemplate.postForEntity(api_Url, translatedEntity,
                TranslatorEntity.class);
        return response.getBody().toString();
    }
}