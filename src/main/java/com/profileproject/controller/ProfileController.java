package com.profileproject.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.profileproject.dao.ProfileDAOInterface;
import com.profileproject.entity.ProfileUser;
import com.profileproject.utility.DAOFactory;

public class ProfileController implements ProfileControllerInterface {

	private BufferedReader br;
	public ProfileController()
	{
		try
		{
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	
	public void createProfile(){
		
		try
		{
		System.out.println("Enter your name");
		String name=br.readLine();
		System.out.println("Enter your password");
		String password=br.readLine();
		System.out.println("Enter your email");
		String email=br.readLine();
		System.out.println("Enter your address");
		String address=br.readLine();
		
		ProfileUser p=new ProfileUser();
		
		p.setName(name);
		p.setPassword(password);
		p.setEmail(email);
		p.setAddress(address);
		
		ProfileDAOInterface pdi=DAOFactory.createDAOMethod();
		
		int i=pdi.createDAOProfile(p);
		
		if(i>0)
		{
			System.out.print("Profile Created Succesfully");
		}
		
		else
		{
			System.out.print("Profile Creation Failed");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void editProfile() {

		try
		{

	     System.out.println("Enter the profile name you want to edit");
	     String name=br.readLine();
	     
	     ProfileUser pu=new ProfileUser();
	     pu.setName(name);
	     
	     ProfileDAOInterface pdi=DAOFactory.createDAOMethod();
	     ProfileUser p1=pdi.viewEditAttribute(pu);
	   
	     if(p1!=null)
	     {
	     System.out.println("Enter new password");
	     String password=br.readLine();
	     System.out.println("Enter new Email");
	     String email=br.readLine();
	     System.out.println("Enter new Address");
	     String address=br.readLine();
	  
	     ProfileUser p=new ProfileUser();
	     p.setName(name);
	     p.setPassword(password);
	     p.setEmail(email);
	     p.setAddress(address);
	     ProfileDAOInterface pdi1=DAOFactory.createDAOMethod();
	     
	     int i=pdi1.editDAOProfile(p);
		
	     if(i>0)
	     {
	    	 System.out.println("Edit Succesfull");
	     }
	     else
	     {
	    	 System.out.println("Edit Unsuccesfull"); 
	     }
	     
	     }
	     else
	     {
	    	 System.out.println("Profile Not Found to be Edited");
	     }
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteProfile() {


		try
		{
		System.out.println("Enter the Profile Name you want to delete");
		String name=br.readLine();
		
		ProfileUser pu=new ProfileUser();
		pu.setName(name);
		ProfileDAOInterface pid=DAOFactory.createDAOMethod();
		int i=pid.deleteDAOProfile(pu);
		
		if(i>0)
		{
			System.out.println("Profile Deleted Succesfully");
		}
		else
		{
			System.out.println("Profile Deletion unSuccesfull");
		}
		}
		catch (Exception e) {

         e.printStackTrace();
		}
		
	}

	public void viewProfile() {


		try
		{
		System.out.println("Enter the Profile you want to View");
		String name=br.readLine();
		ProfileUser pu=new ProfileUser();
		pu.setName(name);
		
		ProfileDAOInterface pid=DAOFactory.createDAOMethod();
		ProfileUser p1=pid.viewDAOProfile(pu);
		
		if(p1!=null)
		{
			System.out.println("Name:"+p1.getName());
			System.out.println("Password:"+p1.getPassword());
			System.out.println("Email:"+p1.getEmail());
			System.out.println("Address:"+p1.getAddress());
		}
		else
		{
			System.out.println("Profile not found");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void loginProfile() {

		try
		{
		
		 System.out.println("Enter the login Information");
         System.out.println("Enter your name=");
         String name=br.readLine();
         System.out.println("Enter your password=");
         String password=br.readLine();
          ProfileUser pu=new ProfileUser();
          pu.setName(name);
          pu.setPassword(password);
         
         
          ProfileDAOInterface pd=DAOFactory.createDAOMethod();
          boolean b=pd.loginDAOProfile(pu);
          
          if(b==true)
          {
        	  System.out.println("Login Succesfull");
          }
          else
          {
        	  System.out.println("Invalid Email and Password");
          }
          
         
		}
		catch(Exception e)
		{
			
		}
	}



}
