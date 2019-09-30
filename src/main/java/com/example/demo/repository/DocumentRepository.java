package com.example.demo.repository;

import com.example.demo.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {

    Document findByKey1(String key1);
}
