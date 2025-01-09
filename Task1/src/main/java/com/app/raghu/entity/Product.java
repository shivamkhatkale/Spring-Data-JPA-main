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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productPractice")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private Integer pId;

	@Column(name = "pname")
	private String pName;

	@Column(name = "psal")
	private Double pSal;

	@Column(name = "phra")
	private Double pHra;

	@Column(name = "pta")
	private Double pTa;

	@Column(name = "edept")
	private String pDept;

}
