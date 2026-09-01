package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Employees implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;
	private Double salary;
	
	public Employees() {
	}

	public Employees(Integer id, String name, String email, Double salary) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Id: " + getId() + "\nNome: " + getName() + "\nEmail: " + getEmail() + "\nSalário: " + getSalary();
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(salary, other.salary);
	}
	
	
	
	
	
	
}
