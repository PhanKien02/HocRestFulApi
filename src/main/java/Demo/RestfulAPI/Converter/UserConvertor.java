package Demo.RestfulAPI.Converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import Demo.RestfulAPI.DTO.UserDTO;
import Demo.RestfulAPI.Entity.*;



@Component
public class UserConvertor {
	public UserDTO toDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getUser_id());
		userDTO.setUsername(userEntity.getUserName());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setFullName(userEntity.getFull_Name());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setAddress(userEntity.getAddress());
		userDTO.setAboutMe(userEntity.getAboutMe());
		
		List<String> roles = new ArrayList<>();
		for(RoleEntity role : userEntity.getRoles())
			roles.add(role.getRoleName());
		userDTO.setRoles(roles);		
		return userDTO;
	}
}
