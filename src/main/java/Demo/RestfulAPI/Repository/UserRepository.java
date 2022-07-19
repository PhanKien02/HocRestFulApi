package Demo.RestfulAPI.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import Demo.RestfulAPI.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	@Query(value = "select * from users as u where u.username = :username", nativeQuery = true)
	public UserEntity findByUserName(String username);
	
	@Query(value = "select * from users as u where u.email = :email", nativeQuery = true)
	public UserEntity findByEmail(String email) ;

	@Query(value = "select * from users as u where u.user_id = :id", nativeQuery = true)
	public UserEntity getUserById(int id);
}
