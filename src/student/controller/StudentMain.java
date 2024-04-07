package student.controller;


import java.sql.SQLException;
import java.util.Scanner;

import student.dto.Student;
import sudent.dao.StudentCrud;

public class StudentMain {
	static Scanner scanner = new Scanner(System.in);
	static StudentCrud crud = new StudentCrud();

	public static void main(String[] args) throws SQLException {

		crud.createTable();

		System.out.println("=== Welcome to Student Management Portal ===");

		boolean menu1 = true;

		do {
			System.out.println("Enter your choice\n 1.Register\n 2.Login\n 3.Exit");

			int key1 = scanner.nextInt();
			switch (key1) {
			case 1: {
				System.out.println("Welcome to Register Page");
				int data = save();

				if (data != 0) {
					System.out.println("Registered successfully...");
				}
			}
				break;
			case 2: {
				System.out.println("=== Welcome to Login Page ===");

				System.out.println("enter email");
				String email = scanner.next();

				Student student = login(email);

				try {
					if (student.getS_email().equals(email)) {
						System.out.println("enter password");
						String password = scanner.next();
						if (student.getS_password().equals(password)) {
							System.out.println("Logged-in Successfully...!!!");
						} else {
							System.out.println("incorrect password try log-in again!!!");
							continue;
						}
					}

				} catch (Exception e) {
					System.out.println("entered email doesn't exist try log-in again!!!");
					continue;
				}

				boolean menu2 = true;

				do {
					System.out.println(
							"Enter your choice\n 1.Update Profile\n 2.Delete Profile\n 3.Fetch Profile\n 4.FetchAll Profiles\n 5.Exit");

					int key2 = scanner.nextInt();

					switch (key2) {
					case 1: {
						System.out.println("Update Profile");

					}
						break;
					case 2: {
						System.out.println("Delete Profile");
						System.out.println("enter id to delete");
						int id = scanner.nextInt();
						
						int result=crud.deleteStudent(id);
						System.out.println(result+" record deleted!!!");
						

					}
						break;
					case 3: {
						System.out.println("Fetch Profile");
						System.out.println("enter the email");
						String mail = scanner.next();
						Student s =crud.fetchStudent(mail);
						System.out.println(s);

					}
						break;
					case 4: {
						System.out.println("FetchAll Profiles");

					}
						break;
					case 5: {
						menu2 = false;
						System.out.println("Exited from Login menu... ");

					}
						break;

					default:
						System.out.println("enter the correct choice");
						break;
					}

				} while (menu2);

			}
				break;
			case 3: {
				menu1 = false;
				System.out.println("Exited from Portal menu... ");

			}
				break;

			default:
				System.out.println("enter the correct choice");
				break;
			}
		} while (menu1);

	}

	public static Student login(String email) {

		Student student = null;
		try {
			student = crud.fetchStudent(email);
		} catch (Exception e) {
			System.out.println("error occured please try again");
		}
		return student;
	}

	public static int save() {

		System.out.println("Enter id");
		int s_id = scanner.nextInt();

		System.out.println("Enter name");
		String s_name = scanner.next();

		System.out.println("Enter email");
		String s_email = scanner.next();

		System.out.println("Enter phone");
		long s_phone = scanner.nextLong();

		System.out.println("Enter age");
		int s_age = scanner.nextInt();

		System.out.println("Enter address");
		String s_address = scanner.next();

		System.out.println("Enter marks");
		double s_marks = scanner.nextDouble();

		System.out.println("Enter password");
		String s_password = scanner.next();

		Student student = new Student(s_id, s_name, s_email, s_phone, s_age, s_address, s_marks, s_password);

		int data = 0;

		try {
			data = crud.saveStudent(student);
		} catch (SQLException e) {
			System.out.println("something error occurred please re-enter details");
			save();
		}
		return data;
	}

}
