package com.example.week3.service;

import com.example.week3.model.SaleAdvertisement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @KafkaListener(topics = "sale-topic", groupId = "group-id")
    public void consume(SaleAdvertisement saleAdvertisement){
        logger.info(String.format("Message Receiver \n %s", saleAdvertisement.getDetailMessage()));
    }
}
