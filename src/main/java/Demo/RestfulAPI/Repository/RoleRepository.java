package Demo.RestfulAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Demo.RestfulAPI.Entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
	@Query(value = "select * from roles as r where r.role_name = :roleName", nativeQuery = true)
	public RoleEntity findByName(String roleName);
}
