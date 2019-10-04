package com.example.demo.controller;

import com.example.demo.model.web.DocumentCreateRequest;
import com.example.demo.model.web.DocumentCreateResponse;
import com.example.demo.service.CreateDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private CreateDocumentService createDocumentService;

    @PostMapping("/save")
    public DocumentCreateResponse saveUser(@RequestBody DocumentCreateRequest documentCreateRequest){
        return createDocumentService.saveDocument(documentCreateRequest);
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        createDocumentService.deleteById(id);
    }

    @GetMapping("/{id}")
    public DocumentCreateResponse getById(@PathVariable("id") Long id) {
        return createDocumentService.getById(id);
    }

    @PutMapping("/save/{id}")
    public DocumentCreateResponse update(@PathVariable Long id,
                                        @RequestBody DocumentCreateRequest documentCreateRequest){
        return createDocumentService.updateDocument(id, documentCreateRequest);
    }
    @GetMapping("/all")
    public List<DocumentCreateResponse> getAll(){
        return createDocumentService.getAll();
    }
}
