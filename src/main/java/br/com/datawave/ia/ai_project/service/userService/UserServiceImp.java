package br.com.datawave.ia.ai_project.service.userService;

import br.com.datawave.ia.ai_project.Infra.Security.AuthenticateFacade;
import br.com.datawave.ia.ai_project.domain.answer.GetAnswersDto;
import br.com.datawave.ia.ai_project.domain.user.DescribeUserDto;
import br.com.datawave.ia.ai_project.domain.user.InsertUserDto;
import br.com.datawave.ia.ai_project.domain.user.User;
import br.com.datawave.ia.ai_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticateFacade facade;

    @Override
    public User loadLogedUser() {
        return repository.findByEmail(facade.getCurrentUser());
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public DescribeUserDto insertUser(InsertUserDto dto){
        var user = new User(dto.nome(), dto.email(), dto.password());
        repository.save(user);
        var answers = user.getAnswers().stream().map(GetAnswersDto::new).toList();
        return new DescribeUserDto(user.getId(), user.getNome(), user.getUsername(), answers);
    };

    @Override
    public DescribeUserDto getUser (Long id){
        var user = repository.getReferenceById(id);
        var answers = user.getAnswers().stream().map(GetAnswersDto::new).toList();
        return new DescribeUserDto(user.getId(), user.getNome(), user.getUsername(), answers);
    };

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }
}
