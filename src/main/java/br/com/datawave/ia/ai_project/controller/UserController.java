package br.com.datawave.ia.ai_project.controller;

import br.com.datawave.ia.ai_project.Infra.Security.TokenReturn;
import br.com.datawave.ia.ai_project.domain.user.DescribeUserDto;
import br.com.datawave.ia.ai_project.domain.user.InsertUserDto;
import br.com.datawave.ia.ai_project.domain.user.User;
import br.com.datawave.ia.ai_project.domain.user.UserLoginDto;
import br.com.datawave.ia.ai_project.service.TokenService;
import br.com.datawave.ia.ai_project.service.userService.UserServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/ai/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserServiceImp service;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

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

    @PostMapping("login")
    public ResponseEntity<TokenReturn> login(@RequestBody @Valid UserLoginDto dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenReturn(tokenJWT));
    }
}
