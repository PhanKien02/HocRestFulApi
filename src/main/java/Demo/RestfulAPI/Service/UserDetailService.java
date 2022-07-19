package Demo.RestfulAPI.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Demo.RestfulAPI.Entity.RoleEntity;
import Demo.RestfulAPI.Entity.UserEntity;
import Demo.RestfulAPI.Repository.UserRepository;



@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Set<RoleEntity> roles = user.getRoles();
		for (RoleEntity role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				grantedAuthorities);
	}
	// tìm user theo tên
	public UserEntity findByUserName(String userName) {
		return userRepository.findByUserName(userName) ;
	}
	// tìm user theo Email
	public UserEntity findByEmail(String Email) {
		return userRepository.findByEmail(Email);
	}
	//Lấy user theo id
	public UserEntity findById(Integer user_id) {
		return userRepository.getUserById(user_id);
	}
	// lấy tất cả các user
	public List<UserEntity> getAllUser() {
		List<UserEntity> userEntities = userRepository.findAll();
		return userEntities;                           
	}
	public UserEntity editProfile(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
}
