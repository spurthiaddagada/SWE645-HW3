/*
 * This script does both GET request from Database and POST request to Database from Form.
 */

package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="http://localhost:4200/")
@Path("/students")
@Produces("application/json")
public class StudentResource {

    @Autowired
    private StudentRepository repo;

    @GET
    @Path("/{stdid}")
    public Student getStudentDetail(@PathParam("stdid") String stdid) {
    	System.out.println("stdid from angular is "+stdid);
        return repo.findByStdid(stdid);
    }

    @GET
    public List<String> getStudentIds() {
        Iterable<Student> students = repo.findAll();
        List<String> idList = new ArrayList<String>();
        for(Student s : students) {
            idList.add(s.getStdid());
           
        }
        return idList;
    }

    @POST
    @Consumes("application/json")
    public List<String> create(Student student) {
    	System.out.println("student from angular "+student.getStdname());
    	List<String> idList = new ArrayList<String>();
    	try {
    		repo.save(student);
    		Iterable<Student> students = repo.findAll();
    		
    		if(students!=null) {
    			for(Student s : students) {
    	            idList.add(s.getStdid());
    	           
    	        }
    		}
    		
    	
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	return idList;
    	
    }

}