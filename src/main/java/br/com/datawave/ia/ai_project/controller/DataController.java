package br.com.datawave.ia.ai_project.controller;

import br.com.datawave.ia.ai_project.domain.data.InputDataContent;
import br.com.datawave.ia.ai_project.domain.data.MessageDto;
import br.com.datawave.ia.ai_project.domain.data.ResponseDto;
import br.com.datawave.ia.ai_project.service.ragService.RagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ai/chat")
@CrossOrigin(origins = "*")
public class DataController {

    @Autowired
    private RagService service;

    @PostMapping
    public ResponseEntity<ResponseDto> chat(@Valid @RequestBody MessageDto messageDTO){
        System.out.println(messageDTO.message());
        var response = service.getDataContent(messageDTO);
        return ResponseEntity.ok().body(new ResponseDto(response));
    }

//    @PostMapping
//    public ResponseEntity<String> feedDataBase(@RequestBody InputDataContent dataContent){
//        service.inputDataContent(dataContent);
//    }

}
