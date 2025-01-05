package com.app.raghu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_shivam")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid")
	private Integer empId;

	@Column(name = "ename")
	private String empName;

	@Column(name = "empsal")
	private Double empSal;

	@Column(name = "emphra")
	private Double empHra;

	@Column(name = "empta")
	private Double empTa;

	@Column(name = "edept")
	private String empDept;

}
