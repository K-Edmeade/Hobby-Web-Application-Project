package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Players {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String dateOfBirth;
	@Column(nullable = false)
	private int transferFee;
	@Column(nullable = false)
	private String nationality;
	@Column(nullable = false)
	private String position;

	public Players() {
		super();
	}

	public Players(String firstName, String lastName, String dateOfBirth, int transferFee, String nationality,
			String position) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.transferFee = transferFee;
		this.nationality = nationality;
		this.position = position;
	}

	public Players(Long id, String firstName, String lastName, String dateOfBirth, int transferFee, String nationality,
			String position) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.transferFee = transferFee;
		this.nationality = nationality;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(int transferFee) {
		this.transferFee = transferFee;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lastName, dateOfBirth, firstName, nationality, position, transferFee);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Players other = (Players) obj;
		return Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(nationality, other.nationality) && Objects.equals(position, other.position)
				&& transferFee == other.transferFee;
	}

}
