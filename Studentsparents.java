package SchoolAssissementParents;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Studentsparents")
	public class Studentsparents extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
	String studentid=req.getParameter("studentid");
	String firstName=req.getParameter("firstName");
	String lastName=req.getParameter("lastName");
	String dob=req.getParameter("dob");
	String parentName=req.getParameter("parentName");
	String address=req.getParameter("address");
	String city=req.getParameter("city");
	String phone=req.getParameter("phone");
	String url="jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
	String insert="insert into studentparents( firstname, lastname, dob, parentsname, address, city, phonenumber)"+"values(?,?,?,?,?,?,?)";
	try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection=DriverManager.getConnection(url);
	PreparedStatement ps=connection.prepareStatement(insert);
	ps.setString(1, firstName);
	ps.setString(2, lastName);
	ps.setString(3, dob);
	ps.setString(4, parentName);
	ps.setString(5, address);
	ps.setString(6, city);
	ps.setString(7, phone);
	int num=ps.executeUpdate();
	if (num>0) {
	System.out.println("inserted");
	} else {
	System.out.println("enter valid details");
	}
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}

	
	
	}


