
/*
 * Using CrudRepository which is a Spring data interface 
 * and to use it we need to create our interface by extending CrudRepository.
 * It provides generic CRUD operation on given repository
 */
package com.example.demo;
import java.security.interfaces.RSAKey;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import antlr.collections.List;

public interface StudentRepository extends CrudRepository<Student, String> {
    Student findByStdid(String stdid);
    
//    Student findByStdId(String stdId)
//    {
//    	connet ot findById(id);
//    	
//    	execture
//    	result 
//    	
//    	Student s1=new Student();
//    	s1.setFistname(rs.getStringByName("firstName"));
//    	
//    	//
//    	return s1;
//    }
    
    
//    @Query(value="select * from student where st_id=:sid",nativeQuery=true)
//    Student findMyStudent(String sid);
}