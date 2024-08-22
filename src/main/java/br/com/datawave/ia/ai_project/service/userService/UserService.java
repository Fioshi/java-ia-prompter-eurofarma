package br.com.datawave.ia.ai_project.service.userService;

import br.com.datawave.ia.ai_project.domain.user.DescribeUserDto;
import br.com.datawave.ia.ai_project.domain.user.InsertUserDto;
import br.com.datawave.ia.ai_project.domain.user.User;
import br.com.datawave.ia.ai_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public DescribeUserDto insertUser(InsertUserDto dto){
        var user = new User(dto.nome(), dto.email());
        repository.save(user);
        return new DescribeUserDto(user.getId(), user.getNome(), user.getEmail(), user.getContents());
    };

    public DescribeUserDto getUser (Long id){
        var user = repository.getReferenceById(id);
        return new DescribeUserDto(user.getId(), user.getNome(), user.getEmail(), user.getContents());
    };
}
