package charityDrop;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AdminPK id;

	private int adminnumdates;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="adminid")
	private User user;

	public Admin() {
	}

	public AdminPK getId() {
		return this.id;
	}

	public void setId(AdminPK id) {
		this.id = id;
	}

	public int getAdminnumdates() {
		return this.adminnumdates;
	}

	public void setAdminnumdates(int adminnumdates) {
		this.adminnumdates = adminnumdates;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}