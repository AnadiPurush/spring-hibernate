package com.utsavsharma.ImportantHibernateSetUp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author ${Utsav Sharma}
 */
@Entity
@Table(name = "Student_Details")
public class StudentEntity {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "StudentName")
	private String Name;
	@Column(name = "StudentCity")
	private String City;

	public StudentEntity() {
		super();
	}

	@Override
	public String toString() {
		return "StudentEntity{" + "Id=" + Id + ", Name=" + Name + ", City=" + City + '}';
	}

	public Integer getId() {
		return Id;
	}

	public StudentEntity(Integer Id, String Name, String City) {
		this.Id = Id;
		this.Name = Name;
		this.City = City;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}

}
