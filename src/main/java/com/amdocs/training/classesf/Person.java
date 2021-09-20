package com.amdocs.training.classesf;

public class Person {
public static int id;
public static String email;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Person() {
	
}
public Person(int id, String email) {
	
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
