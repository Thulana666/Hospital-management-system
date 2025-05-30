package services;

import java.sql.Statement;

import controller.DBConnect;
import model.RegisterModel;

public class RegisterServices {
	public void insertData(RegisterModel regModel) {
		try {
			String name = regModel.getPatientName();
			String gender = regModel.getGender();
			int age = regModel.getAge();
			String mail = regModel.getEmail();
			int tel = regModel.getTel();
			String pwd = regModel.getPwd();
			String add = regModel.getAddress();
			
			Statement stmt = DBConnect.getConnection().createStatement();
			
			String sql = "Insert into Patient(Pat_Name, Gender, Age, phone, Pat_Address, Email, Password)"
						+ "VALUES(" +"'" + name + "','" + gender + "'," + age + "," + tel + ",'" + add + "'," + "'" + mail + "'," + "'" + pwd + "'" + ");";
			
			stmt.executeUpdate(sql);
			stmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
