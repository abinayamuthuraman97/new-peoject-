import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmpDetails {
public static void main(String args[]){
String user,pass;
Scanner sc = new Scanner(System.in);
String drivername="com.mysql.cj.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/task";
String username="root";
String password="root";
try
{
Class.forName(drivername);
}
catch(ClassNotFoundException e)
{
e.printStackTrace();
}
System.out.println("Please select the choice:");
System.out.println("Choose 1 for Login:");
while(true)
{
int n = sc.nextInt();
switch(n)
{

case 1:
	System.out.println("Enter your username:");
	user=sc.next();
	System.out.println("Enter your password:");
	pass=sc.next();
	System.out.println("");
	if(user.equals("aaa") && pass.equals("123"))
	{
		System.out.println("Login successfully");
		System.out.println("Please select the choice:");
		System.out.println("Choose 2 for List all the employee");
		System.out.println("Choose 3 for Get a Employee details");
		System.out.println("Choose 4 for Delete a Employee");
		System.out.println("Choose 5 for Create a employee");
		System.out.println("Choose 6 for Update a employee");
		System.out.println("Choose 7 for Logout");
		System.out.println("Choose the operation you want to perform:");
	}else {
		System.out.println("Login unsuccessfully");
	}
break;

case 2:
	System.out.print("Show all the employee details:");
	System.out.println(" ");
	try{
	Connection con=DriverManager.getConnection(url,username,password);
	Statement st=con.createStatement();
	String query="select * from emptable";
	ResultSet rs=st.executeQuery(query);
	while(rs.next())
	{
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4));
	}
	}
	catch (Exception e) {
	e.printStackTrace();
	System.out.println(e);
	}	
	System.out.print("viewed Successfully");
	System.out.println("Please select the choice:");
	System.out.println("Choose 2 for List all the employee");
	System.out.println("Choose 3 for Get a Employee details");
	System.out.println("Choose 4 for Delete a Employee");
	System.out.println("Choose 5 for Create a employee");
	System.out.println("Choose 6 for Update a employee");
	System.out.println("Choose 7 for Logout");
	System.out.println("Choose the operation you want to perform:");

break;

case 3:
System.out.println("Get employee Id");
	try{
	Connection conn=DriverManager.getConnection(url,username,password);
	Statement st=conn.createStatement();
	int empid = sc.nextInt(); 
	String query="select * from emptable where empid="+empid;
	ResultSet rs=st.executeQuery(query);
	while(rs.next())
	{
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4));
	}
	}
	catch (Exception e) {
	e.printStackTrace();
	System.out.println(e);
	}
	System.out.println("");
	
	System.out.println("Please select the choice:");
	System.out.println("Choose 2 for List all the employee");
	System.out.println("Choose 3 for Get a Employee details");
	System.out.println("Choose 4 for Delete a Employee");
	System.out.println("Choose 5 for Create a employee");
	System.out.println("Choose 6 for Update a employee");
	System.out.println("Choose 7 for Logout");
	System.out.println("Choose the operation you want to perform:");
	break;

case 4:
System.out.println("Enter Id you want to delete");
	try{
	Connection conn=DriverManager.getConnection(url,username,password);
	Statement st=conn.createStatement();
	int empid = sc.nextInt(); 
	String Update="Delete from emptable where empid =" +empid;
	int i2=st.executeUpdate(Update);
	if(i2>0){
	System.out.println("Deleted successfull"); 
	}else {
	System.out.println("Record not found"); 
	}
	}
	catch (Exception e) {
	e.printStackTrace();
	System.out.println(e);
	}
	System.out.println("");
	
	System.out.println("Please select the choice:");
	System.out.println("Choose 2 for List all the employee");
	System.out.println("Choose 3 for Get a Employee details");
	System.out.println("Choose 4 for Delete a Employee");
	System.out.println("Choose 5 for Create a employee");
	System.out.println("Choose 6 for Update a employee");
	System.out.println("Choose 7 for Logout");
	System.out.println("Choose the operation you want to perform:");
	break;

	case 5:
		try{
			Connection conn=DriverManager.getConnection(url,username,password);
			Statement st=conn.createStatement();
			System.out.println("Enter empname:");
			String empname= sc.next();
			System.out.println("Enter email:");
			String email= sc.next();
			System.out.println("Enter age:");
			int age= sc.nextInt();
			String Update="Insert into emptable (empname,email,age)values('"+empname+"','"+email+"','"+age+"')";
			System.out.println(""); 
			st.executeUpdate(Update);
			System.out.println("Record Inserted"); 
			}
			catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			}
		
		System.out.println("Please select the choice:");
		System.out.println("Choose 2 for List all the employee");
		System.out.println("Choose 3 for Get a Employee details");
		System.out.println("Choose 4 for Delete a Employee");
		System.out.println("Choose 5 for Create a employee");
		System.out.println("Choose 6 for Update a employee");
		System.out.println("Choose 7 for Logout");
		System.out.println("Choose the operation you want to perform:");
		break;
		
		
	case 6:
		try{
			Connection conn=DriverManager.getConnection(url,username,password);
			Statement st=conn.createStatement();
			System.out.println("Enter emp Id:");
			int empid = sc.nextInt();
			String q="Select * from emptable where empid='"+empid +"'";
			ResultSet rs=st.executeQuery(q);
			if(rs.next())
			{
				//to show the data
				System.out.println("emp id:"+rs.getString(1));
				System.out.println("1.empname:"+rs.getString(2));
				System.out.println("2.email :"+rs.getString(3));
				System.out.println("3.age :"+rs.getString(4));
				System.out.println("Which Field U Want to Edit?");
				int ch=sc.nextInt();
				String pat="";
				switch(ch)
				{ 
					case 1:
						System.out.print("Enter New empame:");
						String empname=sc.nextLine();
						pat="empname='"+empname+"'";
						break;

					case 2:
						System.out.print("Enter New email:");
						String email=sc.nextLine();
						pat="email='"+email+"'";
						break;

					case 3:
						System.out.print("Enter New age:");
						int age=sc.nextInt();
						pat="age='"+age+"'";
						break;
						
					default:
						System.out.println("Wrong Option");
						break;
				}
				if(!pat.equals(""))
				{
					q="update emptable set "+pat+" where empid='"+empid+"'";
					st.executeUpdate(q);
					System.out.println("Record Updated");
				}
			}else {
				System.out.println("Record Not Found");
			}
		}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
				}
		
		System.out.println("Please select the choice:");
		System.out.println("Choose 2 for List all the employee");
		System.out.println("Choose 3 for Get a Employee details");
		System.out.println("Choose 4 for Delete a Employee");
		System.out.println("Choose 5 for Create a employee");
		System.out.println("Choose 6 for Update a employee");
		System.out.println("Choose 7 for Logout");
		System.out.println("Choose the operation you want to perform:");
		break;
case 7:
System.out.println("Logout");
System.out.println("Please select the choice:");
System.out.println("Choose 1 for Login:");
System.out.println("");
break;
}
}
}
}


