package charityDrop;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class RegistrationEAO
 */
@Stateless(mappedName = "RegistrationEAO")
@LocalBean
public class RegistrationEAO {
	@PersistenceContext()
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public RegistrationEAO() {
        // TODO Auto-generated constructor stub
    }

    public String retfullname(Signing_In signing_In) {
    	String dbURL = "jdbc:mysql://:3306/charityDrop"; 
    	String username ="admin"; 
    	String password = "admin123";
    	Connection dbCon = null; 
    	Statement stmt = null; 
    	ResultSet rs = null; 
    	String fullname=null, lname=null;
    	
    	String user = signing_In.getUsername();
    	String query ="select fname,lname from user where uid='"+ user + "';";
    	 //getting database connection to MySQL server 
		try {
			dbCon = DriverManager.getConnection(dbURL, username, password);
			//getting PreparedStatment to execute query
			stmt = dbCon.prepareStatement(query);
			
			// returned by query
            rs = stmt.executeQuery(query);
           
            while(rs.next()){ 
            	fullname = rs.getString("fname");  
            	lname = rs.getString("lname");  
            }
            
          


           	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fullname.concat(lname);
    }
    public String checkUser(Signing_In signing_In) {
    	
    	String dbURL = "jdbc:mysql://:3306/charityDrop"; 
    	String username ="admin"; 
    	String password = "admin123";
    	Connection dbCon = null; 
    	Statement stmt = null,stmt2 = null; 
    	ResultSet rs = null,rs2 = null ; 
    	String ug=null,pwd=null; 
    	
    	String user = signing_In.getUsername();
    	String pwds = signing_In.getPassword();
    	
    	String query ="select ugroup from user where uid='"+ user + "';";
    	String query2 ="select pwd from user where uid='"+ user + "';";
    	//System.out.println(query);
    	//System.out.println(query2);
    	
    	 //getting database connection to MySQL server 
    		try {
				dbCon = DriverManager.getConnection(dbURL, username, password);
				//getting PreparedStatment to execute query
				stmt = dbCon.prepareStatement(query);
				stmt2 = dbCon.prepareStatement(query2);
				
				// returned by query
	            rs = stmt.executeQuery(query);
	            rs2 = stmt2.executeQuery(query2);
	           
	            while(rs.next()){ 
	            	ug = rs.getString("ugroup");  
	            	}
	            
	            while(rs2.next()){ 
	            	pwd = rs2.getString("pwd");  
	            	}


	           	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		if(ug==null)
    		return null;
    		
    		else
    		return pwd;
    }

	public boolean persistUser(EchoServlet registrationBean) {
		try{
		User user = new User();
		user.setUid(registrationBean.getUsername());
		user.setPwd(Util.hash(registrationBean.getPassword()));
		user.setFname(registrationBean.getFirstname());
		user.setLname(registrationBean.getLastname());
		user.setUgroup(registrationBean.getUgroup());
		user.setEmail(registrationBean.getEmail());
		user.setImage(registrationBean.getImg());
		user.setTel(registrationBean.getTel());
		user.setKpi(registrationBean.getKpi());
		
		Address address = new Address();
		address.setCity(registrationBean.getCity());
		address.setZip(registrationBean.getZip());
		address.setState(registrationBean.getState());
		
		AddressPK addresspk = new AddressPK();
		addresspk.setAddress1(registrationBean.getAddress());
		
		address.setId(addresspk);
		address.setUser(user);
		
		//user.setAddress(address);
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		user.setAddresses((List<Address>) addresses);
		
		
		
		//Query query = this.entityManager.createQuery("SELECT c FROM User c WHERE c.uid=0");
		this.entityManager.persist(user);
		return true;
		} catch(ClassCastException e){
			System.out.println("Class Cast Exception");
			e.printStackTrace();
		} catch (IllegalArgumentException e){
			System.out.println("Illegal Argument Exception");
			e.printStackTrace();
		} catch (Exception e){
			System.out.println("Generic Exception");
			e.printStackTrace();
		}
		return false;
	}

}
