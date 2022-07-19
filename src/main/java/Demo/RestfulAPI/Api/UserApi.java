package Demo.RestfulAPI.Api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Demo.RestfulAPI.Converter.UserConvertor;
import Demo.RestfulAPI.DTO.UserDTO;
import Demo.RestfulAPI.Entity.UserEntity;
import Demo.RestfulAPI.Security.MyUserDetail;
import Demo.RestfulAPI.Service.UserDetailService;

@RestController
public class UserApi {

	@Autowired
	private UserConvertor userConvertor;
	
	@Autowired
	private UserDetailService userService;
	
	@GetMapping("/api/profile")
	public ResponseEntity<Object> showProfile() {
		UserDTO userDTO = null;
		Object principle = 
				(MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		UserEntity userEntity = userService.findById(userDetails.getUserEntity().getId());
		if(principle instanceof MyUserDetail)
			userDTO = userConvertor.toDTO(((MyUserDetail) principle).getUserEntity());
		return new ResponseEntity<Object>(userDTO, HttpStatus.OK);
	}
	
	@GetMapping("/api/admin/users")
	public ResponseEntity<Object> getUsersInfo() {
		List<UserDTO> userDTOs = new ArrayList<>();
		for(UserEntity userEntity : userService.getAllUser())
		userDTOs.add(userConvertor.toDTO(userEntity));
		return new ResponseEntity<Object>(userDTOs, HttpStatus.OK);
	}

}
