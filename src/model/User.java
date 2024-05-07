package model;

public class User {
	private boolean enableRegister;
	private String username;
	private String password;
	private String securityQuestion;
	private String answerQuestion;

	public User(boolean enableRegister, String username, String password, String securityQuestion, String answerQuestion){
		this.enableRegister = enableRegister;
		this.username = username;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.answerQuestion = answerQuestion;
	}
	
	public boolean isEnableRegister() {
		return enableRegister;
	}

	public void setEnableRegister(boolean enableRegister) {
		this.enableRegister = enableRegister;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswerQuestion() {
		return answerQuestion;
	}

	public void setAnswerQuestion(String answerQuestion) {
		this.answerQuestion = answerQuestion;
	}
}
