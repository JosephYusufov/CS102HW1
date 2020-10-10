package users;

public abstract class User {
	protected String username;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String id;
	
	public int authenticate ( String password ) {
		if (password == this.password) {
			return 1;
		} else {
			return 0;
		}
	}
}
