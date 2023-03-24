package entities;

import java.util.Date;

public class Client {

	private String name;
	private String email;
	private Date birthDate;

	public Client() {
	}

	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(name);
		sb.append(" (" + birthDate + ")");
		sb.append(" - " + email);

		return sb.toString();
	}
}