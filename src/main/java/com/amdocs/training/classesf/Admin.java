package com.amdocs.training.classesf;

public class Admin {
public static int id;
public static String email;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Admin() {
	
}
public Admin(int id, String email) {
	
	this.id = id;
	this.email = email;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
