package com.example.week3.service;

import com.example.week3.model.SaleAdvertisement;
import com.example.week3.repository.SaleAdvertisementRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleAdvertisementService {
    private final SaleAdvertisementRepository saleAdvertisementRepository;
    private final KafkaTemplate<String, SaleAdvertisement> kafkaTemplate;

    public SaleAdvertisementService(SaleAdvertisementRepository saleAdvertisementRepository, KafkaTemplate<String, SaleAdvertisement> kafkaTemplate) {
        this.saleAdvertisementRepository = saleAdvertisementRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public SaleAdvertisement createSaleAdvertisement(SaleAdvertisement saleAdvertisement) {
        kafkaTemplate.send("sale-topic", saleAdvertisement);
        return saleAdvertisementRepository.save(saleAdvertisement);
    }

    public List<SaleAdvertisement> getAll(){
        return saleAdvertisementRepository.findAll();
    }
}
