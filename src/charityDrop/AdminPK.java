package charityDrop;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the admin database table.
 * 
 */
@Embeddable
public class AdminPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int adminzip;

	
	private String admindate;

	public AdminPK() {
	}
	public int getAdminzip() {
		return this.adminzip;
	}
	public void setAdminzip(int adminzip) {
		this.adminzip = adminzip;
	}
	public String getAdmindate() {
		return this.admindate;
	}
	public void setAdmindate(String admindate) {
		this.admindate = admindate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AdminPK)) {
			return false;
		}
		AdminPK castOther = (AdminPK)other;
		return 
			(this.adminzip == castOther.adminzip)
			&& this.admindate.equals(castOther.admindate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.adminzip;
		hash = hash * prime + this.admindate.hashCode();
		
		return hash;
	}
}