package Demo.RestfulAPI.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class RoleModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "roleName")
	private String roleName;

	@ManyToMany(mappedBy = "roles")
	private Set<UserModel> users;

	public String getRoleName() {
		return roleName;
	}

	public RoleModel(String roleName) {
		this.roleName = roleName;
	}

}
