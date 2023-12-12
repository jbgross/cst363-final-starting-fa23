import java.sql.Connection;

public class DAO {

	public int validateUsername(Connection con, String username) {
		// return pid for username, if not found, return 0
		// TODO 
		
		return 0;
	}

	/*
	 * con -- JDBC connection 
	 * pid -- the primary id of the current user
	 */
	public int printUnreadBlogs(Connection con, int pid) {
		
		// print the names of users that this user is following 
		
		// TODO 
		
		// get blogs made by user who user pid is following
		// and have not previously been marked as read
		// blogs should be print in order by time (oldest first)
		
		// TODO 
		
		// mark the messages as read by this user
		
		// TODO 

		// return the number of messages printed 
		
		// TODO 

		return 0;
	}

}
