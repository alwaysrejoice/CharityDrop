package charityDrop;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the address database table.
 * 
 */
@Embeddable
public class AddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String uid;

	private String address1;

	public AddressPK() {
	}
	public String getUid() {
		return this.uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAddress1() {
		return this.address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AddressPK)) {
			return false;
		}
		AddressPK castOther = (AddressPK)other;
		return 
			this.uid.equals(castOther.uid)
			&& this.address1.equals(castOther.address1);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.uid.hashCode();
		hash = hash * prime + this.address1.hashCode();
		
		return hash;
	}
}