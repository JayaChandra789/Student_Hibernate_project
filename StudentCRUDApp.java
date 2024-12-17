package com.databasemanagament.studentmanagment;

import com.databasemanagament.studentmanagment.dao.*;
import com.databasemanagament.studentmanagment.entity.*;
import com.databasemanagament.studentmanagment.utility.*;

import java.io.*;

public class StudentCRUDApp 
{
	public static void main(String[] args) throws IOException
	{
	
	//StudentUtility su = new StudentUtility();  // no need again just for connection purpose in line 36
		/*DAO class object*/
	StudentDAO studentdao=new StudentDAO();
	/*---- Creating BufferedReader to input data from user--*/

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	/*-----------------------------------------------------------------------*/
	System.out.print("Enter Student Id: ");
	int stdId = Integer.parseInt(br.readLine());

	System.out.print("Enter Student Name: ");
	String stdName = br.readLine();

	System.out.print("Enter age in year: ");
	int stdAge = Integer.parseInt(br.readLine());

	System.out.print("Enter Address: ");
	String stdAddress = br.readLine();
	/*-----------------------------------------------------------------------------*/
	StudentEntities student = new StudentEntities(stdId,stdName,stdAge,stdAddress);

	/*---- inserting into database ----*/
	int row = studentdao.insertStudent(StudentUtility.getConnection(), student); //Using connection from static connection of utility class without object
	}
}
