package com.example.demo.service.impl;

import com.example.demo.model.entity.Document;
import com.example.demo.model.web.DocumentCreateRequest;
import com.example.demo.model.web.DocumentCreateResponse;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.service.CreateDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreateDocumentServiceImpl implements CreateDocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public DocumentCreateResponse saveDocument(DocumentCreateRequest documentCreateRequest) {

        Document document = Document.builder()
                .key1(documentCreateRequest.getKey1())
                .key2(documentCreateRequest.getKey2())
                .build();

            documentRepository.save(document);


        return DocumentCreateResponse.builder()
                .id(document.getId())
                .key1(document.getKey1())
                .key2(document.getKey2())
                .build();
    }

    @Override
    public void deleteById(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public DocumentCreateResponse getById(Long id) {
        return documentRepository
                .findById(id)
                .map(document -> transform(document))
                .orElse(null);
    }

    @Override
    public DocumentCreateResponse updateDocument(Long id, DocumentCreateRequest documentCreateRequest) {

        Document document = Document.builder()
                .id(id)
                .key1(documentCreateRequest.getKey1())
                .key2(documentCreateRequest.getKey2())
                .build();

        documentRepository.saveAndFlush(document);



        return DocumentCreateResponse
                .builder()
                .id(document.getId())
                .key1(document.getKey1())
                .key2(document.getKey2())
                .build();
    }

    @Override
    public List<DocumentCreateResponse> getAll() {
        return documentRepository.findAll()
                .stream()
                .map(document -> transform(document))
                .collect(Collectors.toList());
    }

    private  DocumentCreateResponse transform(Document document){
        return DocumentCreateResponse.builder()
                .id(document.getId())
                .key1(document.getKey1())
                .key2(document.getKey2())
                .build();
    }
}
