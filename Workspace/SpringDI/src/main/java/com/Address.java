package com;

public class Address {
private String city;
private String state;
public String getCity() {
	return city;
}

@Override
public String toString() {
	return "Address [city=" + city + ", state=" + state + "]";
}

public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}

}
