package com.app.shivam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_tab")
public class Product {

	@Id
	@Column(name = "pid")
	private Integer pId;
	@Column(name = "pname")
	private String pName;
	@Column(name = "pcost")
	private Double prodCost;

}
