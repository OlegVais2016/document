package com.example.demo.service.impl;

import com.example.demo.model.entity.Document;
import com.example.demo.model.web.DocumentCreateRequest;
import com.example.demo.model.web.DocumentCreateResponse;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.service.CreateDocumentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateDocumentTest {

    private static final String CORRECT_KEY1 = "value1";
    private static final String CORRECT_KEY2 = "value2";

    private static final Document DEFAULT_DOCUMENT =
            Document.builder()
                    .key1(CORRECT_KEY1)
                    .key2(CORRECT_KEY2)
                    .build();
    @InjectMocks
    private CreateDocumentServiceImpl createDocumentService;

    @Mock
    private DocumentRepository documentRepository;

    @Test
    public void creation_positive(){
        Mockito.when(documentRepository.save(ArgumentMatchers
                .any(Document.class))).thenReturn(DEFAULT_DOCUMENT);
        DocumentCreateRequest request = DocumentCreateRequest.builder()
                .key1(DEFAULT_DOCUMENT.getKey1())
                .key2(DEFAULT_DOCUMENT.getKey2())
                .build();
        DocumentCreateResponse response = createDocumentService.saveDocument(request);
        Assert.assertNotNull(response.getKey1());
        Assert.assertEquals(response.getKey1(),DEFAULT_DOCUMENT.getKey1());
    }
}



//        DocumentCreateRequest request = DocumentCreateRequest.builder()
//                .key1(CORRECT_KEY1)
//                .key2(CORRECT_KEY2)
//                .build();
//        Mockito.lenient().when(documentRepository.findByKey1(CORRECT_KEY1))
//                .thenReturn(DEFAULT_DOCUMENT);
//        DocumentCreateResponse response = createDocumentService.saveDocument(request);
//        Assert.assertNotNull(response.getKey1());
//        Assert.assertEquals(response.getKey1(),DEFAULT_DOCUMENT.getKey1());