package uh.ahci.utils;

public class Address {
	
	private String _street = "";
	private int _nr = 0;
	private int _box = 0;
	private String _postalCode = "";
	private String _city = "";
	private String _country = "";
	
	public Address() {
		
	}

	public String getStreet() {
		return _street;
	}

	public void setStreet(String street) {
		_street = street;
	}

	public int getNr() {
		return _nr;
	}

	public void setNr(int nr) {
		_nr = nr;
	}

	public int getBox() {
		return _box;
	}

	public void setBox(int box) {
		_box = box;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}
	
	
}
