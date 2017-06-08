package charityDrop;

import javax.servlet.http.*;
import java.io.*;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.util.List;

@ManagedBean(name="Signing_In")

@MultipartConfig
@WebServlet(name = "Signing_In", urlPatterns = {"/signing_in"}) 
public class Signing_In extends HttpServlet {
	@EJB RegistrationEAO service;
	private String username="aayush";
    private String password;
    public String fullname;
    
    
	@Override
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
			
			 setUsername(request.getParameter("uname"));
			 setPassword(request.getParameter("pwd"));
			 
			 String logincheck = checkingUser();
			 if(logincheck ==null){
				 
				 // User doesn't exists in the system 
				 response.sendRedirect("signin.html");
			 }else{
				 // Verifying password 
				 if(logincheck.equals(Util.hash(password)))
					 {setFullname(returnname());
				 	//System.out.println(fullname);
					 if(whatgroup().equals("Donor")){
					 response.sendRedirect("user.html");
					 }
					 else if (whatgroup().equals("Admin")){
						 response.sendRedirect("admin.html");
					 }
					 else{
						 response.sendRedirect("truckdriv.html");
					 }
					 }
				 	
				 else
					 {System.out.println(logincheck);
					  response.sendRedirect("signin.html");} 
			 }
			 
			 
		
	}
	private String returnname() {
		return service.retfullname(this);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String checkingUser() {
		//System.out.println(this.username);
		return service.checkUser(this);
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String whatgroup(){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "charityDrop" );
	      EntityManager entitymanager = emfactory.createEntityManager();
	      User query = entitymanager.find(User.class, getUsername());
	      return query.getUgroup();
	      
	}
}
