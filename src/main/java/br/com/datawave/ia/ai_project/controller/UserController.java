package br.com.datawave.ia.ai_project.controller;

import br.com.datawave.ia.ai_project.domain.user.DescribeUserDto;
import br.com.datawave.ia.ai_project.domain.user.InsertUserDto;
import br.com.datawave.ia.ai_project.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/ai/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<DescribeUserDto> insertUser (@RequestBody InsertUserDto dto, UriComponentsBuilder builder){
        var user = service.insertUser(dto);
        var uri = builder.path("ai/user/{id}").buildAndExpand(user.id()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<DescribeUserDto> getUser (@PathVariable Long id){
        return ResponseEntity.ok().body(service.getUser(id));
    }
}
