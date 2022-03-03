package com.example.springboot;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot.repository.UserRepository;
import com.example.springboot.model.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class PhDAdmissionUserApplicationTests {

	@Autowired
	private UserRepository userrep;
	
	@Test
	@Order(1)
	public void createUser()
	{
	   User user=new User();
	   String name="Mikeala";
	   String password="mik@1998";
	   String confirmpassword="mik@1998";
	   String email="mikealastone@gmail.com";
	   user.setId(5);
	   user.setUsername(name);
	   user.setEmail(email);
	   user.setPassword(password);
	   user.setConfirmpassword(confirmpassword);
	   user.setMobilenumber("7466256455");
	   user.setUserrole("user");
	   if((userrep.findByEmailAndPassword(email, password) == null)&&(!name.equals(password))&&(password.equals(confirmpassword)))
		   userrep.save(user);  
	  
	   assertNotNull(userrep.findById(4).get());
			   
	   
	}
	
	@Test
	@Order(2)
	public void testAllUsers()
	{
		List<User> list=(List<User>) userrep.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testgetUserById()
	{
		User u=userrep.findById(4).get();
//		assertThat(u).isNotNull();
		assertAll(
				()->assertEquals("swetha",u.getUsername()),
				()->assertEquals("swetha@gmail.com",u.getEmail()),
				()->assertEquals("SwethA@1200",u.getPassword()),
				()->assertEquals("SwethA@1200",u.getConfirmpassword()),
				()->assertEquals("9278843324",u.getMobilenumber()),
				()->assertEquals("admin",u.getUserrole())
				);
		
	}
	
	
	@Test
	@Order(4)
	public void testUpdateUserById()
	{
		User u=userrep.findById(2).get();
		u.setUsername("Chintu45");
		u.setPassword("chintu@10roy");
		u.setConfirmpassword("chintu@10roy");
		u.setMobilenumber("8979003324");
		userrep.save(u);
		assertAll(
				()->assertEquals("chintu1545@gmail.com",u.getEmail()),
				()->assertNotEquals("Chintu",u.getUsername()),
				()->assertNotEquals("chintu@roy",u.getPassword()),
				()->assertNotEquals("chintu@roy",u.getConfirmpassword()),
				()->assertNotEquals("8979043324",u.getMobilenumber()),
                ()->assertEquals("user",u.getUserrole())
				);
	}
	
	@Test
	@Order(5)
	public void testUpdateUserByName()
	{
		User u=userrep.findByusername("ritin");
		u.setPassword("kukkamudiritin");
		u.setConfirmpassword("kukkamudiritin");
		u.setMobilenumber("6970943324");
		userrep.save(u);
		assertAll(
				()->assertEquals("ritin",u.getUsername()),
				()->assertEquals("ritin45@gmail.com",u.getEmail()),
				()->assertNotEquals("ritinjay",u.getPassword()),
				()->assertNotEquals("ritinjay",u.getConfirmpassword()),
				()->assertNotEquals("7476538476",u.getMobilenumber()),
				()->assertEquals("admin",u.getUserrole())

				);
	}
	
	@Test
	@Order(7)
	public void testDeleteUserById()
	{
		userrep.deleteById(6);
		assertThat(userrep.existsById(6)).isFalse();
	}
	
	@Test
	@Order(6)
	public void testLoginDetails()
	{
		User u=userrep.findByEmailAndPassword("swetha@gmail.com", "SwethA@1200");
		String username=u.getUsername();
		String confirmpassword=u.getConfirmpassword();
		String mobile=u.getMobilenumber();
		String role=u.getUserrole();
		assertAll(
				()->assertEquals("swetha",username),
				()->assertEquals("SwethA@1200",confirmpassword),
				()->assertEquals("9278843324",mobile),
				()->assertEquals("admin",role)
				);
	}
	
	
}

