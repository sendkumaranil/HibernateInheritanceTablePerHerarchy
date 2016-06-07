package com.hibernate.inheritance.tabperhirarchy.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
@DiscriminatorValue(value="Regular")
public class RegularEmployee extends Employee {

	@Column
	private float salary;
	@Column
	private float bonus;
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	
	
	
}
