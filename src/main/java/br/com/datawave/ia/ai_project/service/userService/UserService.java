package br.com.datawave.ia.ai_project.service.userService;

import br.com.datawave.ia.ai_project.domain.user.DescribeUserDto;
import br.com.datawave.ia.ai_project.domain.user.InsertUserDto;
import br.com.datawave.ia.ai_project.domain.user.User;

public interface UserService {

    public DescribeUserDto insertUser(InsertUserDto dto);

    public DescribeUserDto getUser (Long id);
}
