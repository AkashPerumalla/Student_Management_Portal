package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

import student.dto.Student;

public class StudentCrud {

	public Connection createTable() throws SQLException {
		DriverManager.registerDriver(new Driver());
		String url = "jdbc:mysql://localhost:3306/studentdb?createDatabaseIfNotExist=true";
		Connection connection = DriverManager.getConnection(url, "root", "root");
		
		Statement statement = connection.createStatement();
		String sql = "create table if not exists studentdb.student (id int(10) primary key, name varchar(45), email varchar(45), phone bigint, age tinyint(3), address varchar(45), marks double, s_rank int, password varchar(45))"; 
		
		if(statement.execute(sql)) {
			System.out.println("Created table successfully... ");
		
		}
		statement.close();
		
		return connection;
		
	}

	public int saveStudent(Student student) throws SQLException {
		
		
		Connection connection = createTable();
		
		String sql = "insert into student values(?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, student.getS_id());
		preparedStatement.setString(2, student.getS_name());
		preparedStatement.setString(3, student.getS_email());
		preparedStatement.setLong(4, student.getS_phone());
		preparedStatement.setInt(5, student.getS_age());
		preparedStatement.setString(6, student.getS_address());
		preparedStatement.setDouble(7, student.getS_marks());
		preparedStatement.setInt(8, student.getS_rank());
		preparedStatement.setString(9, student.getS_password());
		
		return preparedStatement.executeUpdate();
		
	}
	
	
	

	public int updateStudent(int id) throws SQLException {
		Connection connection = createTable();
		
		System.out.println("enter the id of student to update details: ");
		
		String sql = "update student set =? where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(2, id);
				
		return preparedStatement.executeUpdate();
	}
	
	
	

	public int deleteStudent(int id) throws SQLException {
		Connection connection = createTable();
		String sql = "delete from student where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		return preparedStatement.executeUpdate();
	}
	
	public Student fetchStudent(String email) throws SQLException {
		
		Connection connection = createTable();
		
		String sql = "select * from student where email=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Student student = null;
		
		while (resultSet.next()) {
			
			int s_id = resultSet.getInt("id");
			String s_name = resultSet.getString("name");
			long s_phone = resultSet.getLong("phone");
			int s_age = resultSet.getInt("age");
			String s_address = resultSet.getString("address");;
			double s_marks = resultSet.getDouble("marks");
			
			String s_email= resultSet.getString("email");
			String s_password = resultSet.getString("password");
			
			student = new Student(s_id, s_name, s_email, s_phone, s_age, s_address, s_marks, s_password) ;
		}
		return student;
	}
	
	public void fetchAllStudent() {

	}
	
}
