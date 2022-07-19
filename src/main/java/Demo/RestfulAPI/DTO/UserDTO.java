package Demo.RestfulAPI.DTO;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
	private int id;
	private String username;
	private String password;
	private String fullName;
	private String Email;
	private String Address;
	private String AboutMe;
	private List<String> roles;
}
