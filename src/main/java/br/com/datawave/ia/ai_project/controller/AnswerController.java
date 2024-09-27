package br.com.datawave.ia.ai_project.controller;

import br.com.datawave.ia.ai_project.domain.answer.InsertAnswerDto;
import br.com.datawave.ia.ai_project.service.answerService.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService service;

//    @GetMapping
//    public ResponseEntity<List<>> feedDataBase(){
//
//    }

}
