package com.databasemanagament.studentmanagment.dao;
import java.sql.*;

import com.databasemanagament.studentmanagment.entity.StudentEntities; /*Mandate to import package of entities or were you stored values in entity program as it is encapsulated / private*/

public class StudentDAO 
{
	public int insertStudent(Connection conObj, StudentEntities studentObj) 
	{
		int rows = 0;
		try 
		{
			if (conObj != null) 
			{
				/*----Creating PreparedStatement---*/
				PreparedStatement preStmtObj = conObj.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");
				/*------------------------------------------------------------------------------*/
				/*-----Setting data into prepared statement------*/
				preStmtObj.setString(1, studentObj.getStdName());  //Invoked from getter and setter from entity class
				preStmtObj.setInt(2, studentObj.getStdAge());      //Invoked from getter and setter from entity class
				preStmtObj.setInt(3, studentObj.getStdId()); 		//Invoked from getter and setter from entity class
				preStmtObj.setString(4, studentObj.getStdAddress()); //Invoked from getter and setter from entity class
				/*----------------------------------------------------------*/
				/*--------To execute query-------*/
				rows = preStmtObj.executeUpdate();
				return rows;
			} 
			else 
			{
				return rows;
			}
		} 
		catch (SQLException SQLObj) 
		{
			System.out.println(SQLObj);
			return rows;
		}
	}
	
	/* Method to update Age */
    public int updateRoll(Connection conObj, int stdId, int newAge) 
    {
        int rows = 0;
        try 
        {
            if (conObj != null) 
            {
                PreparedStatement preStmtObj = conObj.prepareStatement("UPDATE student SET age = ? WHERE stdAge = ?");
                preStmtObj.setInt(1, newAge);
                preStmtObj.setInt(2, stdId);
                /*--------To execute query-------*/
                rows = preStmtObj.executeUpdate();
                return rows;
            } 
            else 
            {
                return rows;
            }
        } 
        catch (SQLException SQLObj) 
        {
            System.out.println(SQLObj);
            return rows;
        }
    }
    /* Method to update Address */
    public int updateAddress(Connection conObj, int stdId, String newAddress) 
    {
        int rows = 0;
        try 
        {
            if (conObj != null) 
            {
                PreparedStatement preStmtObj = conObj.prepareStatement("UPDATE student SET address = ? WHERE stdId = ?");
                preStmtObj.setString(1, newAddress);
                preStmtObj.setInt(2, stdId);
                /*--------To execute query-------*/
                rows = preStmtObj.executeUpdate();
                return rows;
            } 
            else 
            {
                return rows;
            }
        } 
        catch (SQLException SQLObj) 
        {
            System.out.println(SQLObj);
            return rows;
        }
    }
}
