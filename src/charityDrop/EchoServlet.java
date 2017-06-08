package charityDrop;

import javax.servlet.http.*;
import java.io.*;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.util.*;


@MultipartConfig
@WebServlet(name = "EchoServlet", urlPatterns = {"/echo"}) 
public class EchoServlet extends HttpServlet {
	@EJB RegistrationEAO service;
	private String username;
    private String password;
    private String confirmpassword;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String city;
    private Integer zip;
    private String State;
    private String Ugroup;
    private String Img;
    private String tel;
    private String kpi;
    
	@Override
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
			 setTel(request.getParameter("tel"));
			 setUsername(request.getParameter("uid"));
			 setPassword(request.getParameter("password"));
			 setConfirmpassword(request.getParameter("cpassword"));
			 setFirstname(request.getParameter("fname"));
			 setLastname(request.getParameter("lname"));
			 setEmail(request.getParameter("email"));
			 setCity(request.getParameter("city"));
			 setZip(Integer.parseInt(request.getParameter("zip")));
			 setState(request.getParameter("state"));
			 setUgroup(request.getParameter("ugroup"));
			 setImg(request.getParameter("file"));
			 setAddress(request.getParameter("address"));
			 setKpi(request.getParameter("howToKnow"));
			 
			 String temp = addUser();
			 if(temp =="success"){
				 response.sendRedirect("signin.html");
			 }else{
				 response.sendRedirect("signup.html");
			 }
		
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
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getUgroup() {
		return Ugroup;
	}
	public void setUgroup(String ugroup) {
		Ugroup = ugroup;
	}
	public String getImg() {
		return Img;
	}
	public void setImg(String img) throws IOException {
		Img = img;
	}
	
	    public String addUser(){
	     if(service.persistUser(this))
	        return"success";
	      //if unsuccessful, return "failure"
	    
	     return "failure";
	    }
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getKpi() {
			return kpi;
		}
		public void setKpi(String kpi) {
			this.kpi = kpi;
		}
}
