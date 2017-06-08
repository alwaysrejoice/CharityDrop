package charityDrop;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;


@WebServlet(name = "catchdates", urlPatterns = {"/catchdates"}) 
public class Catchdates extends HttpServlet{
	
    public Catchdates(){};
    int num = 0;
	public String[] catch_dates(){	   
	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "charityDrop" );
	      EntityManager entitymanager = emfactory.createEntityManager();
	      
	      //Between
	      int zip = 12345;
	      Query query = entitymanager.createQuery( "Select e from Admin e where e.id.adminzip= "+zip);
	      List<Admin> list=(List<Admin>)query.getResultList( );
	     
	      for (Admin e:list){
	    	  num = e.getAdminnumdates();
	    	  break;
	      }
	      String[] dates = new String[num];
	      int i=0;
	      for( Admin e:list ){
	          dates[i] = e.getId().getAdmindate();
	          i++;
	      }
	      return dates;
	      }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] text = catch_dates();
		Signing_In fullname = new Signing_In();
		List<String> list = new ArrayList<String>();
		for(int i=0; i<num; i++){
			list.add(text[i]);
		}
		String json = new Gson().toJson(list);
	    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(json);  // Write response body.
	}
	      

	      

	     
	     
	   }
	

