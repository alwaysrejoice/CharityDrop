package charityDrop;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the booking database table.
 * 
 */
@Embeddable
public class BookingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String userid;

	private String bookid;

	public BookingPK() {
	}
	public String getUserid() {
		return this.userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBookid() {
		return this.bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BookingPK)) {
			return false;
		}
		BookingPK castOther = (BookingPK)other;
		return 
			this.userid.equals(castOther.userid)
			&& this.bookid.equals(castOther.bookid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userid.hashCode();
		hash = hash * prime + this.bookid.hashCode();
		
		return hash;
	}
}