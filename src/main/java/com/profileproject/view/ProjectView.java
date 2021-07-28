package com.profileproject.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.profileproject.controller.ProfileControllerInterface;
import com.profileproject.utility.ProfileFactory;

public class ProjectView {

	public static void main(String[] args) {

		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String x="y";
		
		while(x.equals("y"))
		{
		System.out.println("*************MAIN MENU***************");
		System.out.println("Press 1 to create profile");
		System.out.println("Press 2 to edit profile");
		System.out.println("Press 3 to delete profile");
		System.out.println("Press 4 to view profile");
		System.out.println("Press 5 to login profile");

		try
		{
		int ch;
		ch=Integer.parseInt(br.readLine());
		
		ProfileControllerInterface pc=ProfileFactory.createObject();
		boolean t=true;
		
		
		switch(ch)
		{
		
		
		case 1:
			pc.createProfile();
			break;
			
        case 2:
			pc.editProfile();
			break;
			
        case 3:

        	pc.deleteProfile();
	        break;
        case 4: 
        	pc.viewProfile();
        	break;
        case 5:
        	pc.loginProfile();
        	
        	break;
	
	
	
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	System.out.println("\n");
		System.out.println("do you want to continue?(y/n)");
	
		try
		{
		x=br.readLine();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}

}
