package com.example.demo.service;

import com.example.demo.model.web.DocumentCreateRequest;
import com.example.demo.model.web.DocumentCreateResponse;

import java.util.List;

public interface CreateDocumentService {

    DocumentCreateResponse saveDocument(DocumentCreateRequest documentCreateRequest);
    void deleteById(Long id);
    DocumentCreateResponse getById(Long id);
    DocumentCreateResponse updateDocument(Long id, DocumentCreateRequest documentCreateRequest);
    List<DocumentCreateResponse> getAll();
}
