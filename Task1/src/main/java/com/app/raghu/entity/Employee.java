package com.app.raghu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	@Column(name = "empid")
	private Integer empId;

	@Column(name = "empname")
	private String empName;

	@Column(name = "empsal")
	private Double empSal;

	@Column(name = "hra")
	private Double empHra;

	@Column(name = "ta")
	private Double empTa;

	@Column(name = "empdept")
	private String empDept;

}
