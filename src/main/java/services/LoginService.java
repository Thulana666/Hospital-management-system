package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.DBConnect;

public class LoginService {
	public boolean validateUser(String username, String password) {
        boolean status = false;
        
        try {
            String sql = "SELECT *  FROM Patient  WHERE Pat_Name = ? AND  Password = ?";
            Connection con =  DBConnect.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            status = resultSet.next();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
	
	
	public boolean validateDoctor(String username, String password) {
        boolean status = false;
        
        try {
            String sql = "SELECT *  FROM Doctor  WHERE Doc_Name = ? AND  password = ?";
            Connection con =  DBConnect.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            status = resultSet.next();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
	
	
	public boolean validateReceptionist(String username, String password) {
        boolean status = false;
        
        try {
            String sql = "SELECT *  FROM Receptionist  WHERE Username = ? AND  password = ?";
            Connection con =  DBConnect.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            status = resultSet.next();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
	
	
	public boolean validateAdmin(String username, String password) {
        boolean status = false;
        
        try {
            String sql = "SELECT *  FROM Admin  WHERE Username = ? AND  Password = ?";
            Connection con =  DBConnect.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            status = resultSet.next();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
}
