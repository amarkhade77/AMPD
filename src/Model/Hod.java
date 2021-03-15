package Model;
import java.sql.*;
import java.sql.PreparedStatement;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.sql.ResultSet;

public class Hod {
	
	connect connection=new connect();
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Statement ps=null;
	ResultSet rs=null;
	
	
	
	public boolean CreateBatch()
	{
		
		boolean result=false;
		int count = 0;
	
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\nEnter Batch Name:");
			String batch_name=br.readLine();
			String s1="select c_id,name from class";
			ResultSet rSet=ps.executeQuery(s1);
			while(rs.next())
			{
				int c_id=rs.getInt("c_id");
				String name=rs.getString("name");
				
				System.out.println("ID:"+c_id);
				System.out.println("NAME:"+name);
				
			}
			System.out.println("\nEnter Class Id:");
			int c_id=Integer.parseInt(br.readLine());
			
			String s2="select * from tecaher";
			ResultSet rset=ps.executeQuery(s2);
			while(rs.next())
			{
				int t_id=rs.getInt("t_id");
				String first_name=rs.getString("first_name");
				String last_name=rs.getString("last_name");
				String email=rs.getString("email");
				
				System.out.println("ID:"+t_id);
				System.out.println("FirstName:"+first_name);
				System.out.println("LastName:"+last_name);
				System.out.println("Email:"+email);
				
				
			}
			System.out.println("\nEnter Teacher Id:");
			int t_id=Integer.parseInt(br.readLine());
			
			connection.close();
			if(count == 1)
			{
				result = true;
			}
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return result;
		
}
			
			
			/*PreparedStatement ps = connection.conn.prepareStatement("insert into batch values(default,?,?,?);");
			ps.setString(1,batch_name);
			ps.setInt(2,c_id);
			ps.setInt(3,t_id);
			count = ps.executeUpdate();
			if(count == 1)
			{
				result = true;
			}
			connection.close();
			ps.close();
			
		}*/
	
	public boolean CreateClass()
	{
		
		boolean result=false;
		int count=0;
		
		try {
			
			PreparedStatement ps = connection.conn.prepareStatement("insert into class values(default,?);");
			System.out.println("Enter Class Name:");
			String name=br.readLine();
			ps.setString(1,name);
			count = ps.executeUpdate();
			if(count == 1)
			{
				result = true;
			}
			connection.close();
			ps.close();
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			// TODO: handle exception
		}
		return result;
	}
		
	/*public boolean CreateClass(String name)
	{
		
		boolean result=false;
	int count = 0;
		try {
			PreparedStatement ps = connection.conn.prepareStatement("insert into class values(default,?);");
			ps.setString(1,name);
			count = ps.executeUpdate();
			if(count == 1)
			{
				result = true;
			}
			connection.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;

	}*/
	
	
	
	public boolean AddSubject()
	{
		boolean result=false;
		int count=0;
		
		try {
			
			System.out.println("\nEnter Subject Name:");
			String sub_name=br.readLine();
			
			String s1="select c_id,name from class";
			ResultSet rSet=ps.executeQuery(s1);
			while(rs.next())
			{
				int c_id=rs.getInt("c_id");
				String name=rs.getString("name");
				
				System.out.println("ID:"+c_id);
				System.out.println("NAME:"+name);
				
			}
			System.out.println("\nEnter Class Id:");
			int c_id=Integer.parseInt(br.readLine());
			
			connection.close();
			if(count == 1)
			{
				result = true;
			}
			
			
		}
		
		
		catch (Exception e)
		{
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
		
	}
	
	/*public boolean CreateSubject(int c_id, String sub_name)
	{
		boolean result = false;
		int count = 0;
		try 
		{
			PreparedStatement ps = connection.conn.prepareStatement("insert into Subject values(default,?,?)");
			ps.setString(2,sub_name);
			ps.setInt(1,c_id);
			count = ps.executeUpdate();
			ps.close();
			connection.close();
			if(count == 1)
			{
				result = true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}*/
	
	public boolean AssignTeacher()
	{
		boolean result=false;
		int count=0;
		
		try {
			
			CreateBatch();
			
			connection.close();
			if(count == 1)
			{
				result = true;
			}
		} 
		
		
		catch (Exception e) {
			// TODO: handle exception
		System.out.println(e);
		}
		return result;
	}
	
	public static void main()
	{
		
		int choice;
		Hod h1=new Hod();
		Scanner sc=new Scanner(System.in);
	System.out.println("\n1.Create Batch\n2.Create Class\n3.Add New Subject\n 4.AssignTeacher\n5.Exit");
		System.out.println("\nEnter your Choice...\n");
		choice=sc.nextInt();
		
		switch (choice) {
		case 1:
			h1.CreateBatch();
				break;
		case 2:
				h1.CreateClass();
				
		case 3:
				h1.AddSubject();
		case 4:
			h1.AssignTeacher();

		default:System.out.println("Invalid Choice...");
			break;
		}
		
	}
	
	
	

}
