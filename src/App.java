import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class App {
	
	static final String DBURL="jdbc:mysql://localhost:3306/blog";
	static final String DBUSER="root";
	static final String DBPASSWORD="secret";

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		try (Connection con = DriverManager.getConnection(DBURL,  DBUSER, DBPASSWORD) ) {
			con.setAutoCommit(false);
			
			DAO dao = new DAO();
				
			while (true) {
			
				System.out.println();
				System.out.print("Enter username or quit: ");
				String username = keyboard.nextLine();
				
				if (username.equals("quit")) break;
				
				int pid = dao.validateUsername(con,  username);
				
				if (pid==0) {
					System.out.println("username not found.");
					continue;
				}
				
				// display unread messages 
				dao.printUnreadBlogs(con,  pid);
				
				con.commit();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			keyboard.close();
		}
	}


}
