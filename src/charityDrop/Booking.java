package charityDrop;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the booking database table.
 * 
 */
@Entity
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BookingPK id;

	private String bookdate;

	private String bookstatus;

	@Lob
	private String descofdon;

	@Temporal(TemporalType.TIMESTAMP)
	private Date frmtime;

	private int qty;

	private String size;

	@Temporal(TemporalType.TIMESTAMP)
	private Date totimee;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	public Booking() {
	}

	public BookingPK getId() {
		return this.id;
	}

	public void setId(BookingPK id) {
		this.id = id;
	}

	public String getBookdate() {
		return this.bookdate;
	}

	public void setBookdate(String bookdate) {
		this.bookdate = bookdate;
	}

	public String getBookstatus() {
		return this.bookstatus;
	}

	public void setBookstatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}

	public String getDescofdon() {
		return this.descofdon;
	}

	public void setDescofdon(String descofdon) {
		this.descofdon = descofdon;
	}

	public Date getFrmtime() {
		return this.frmtime;
	}

	public void setFrmtime(Date frmtime) {
		this.frmtime = frmtime;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Date getTotimee() {
		return this.totimee;
	}

	public void setTotimee(Date totimee) {
		this.totimee = totimee;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}