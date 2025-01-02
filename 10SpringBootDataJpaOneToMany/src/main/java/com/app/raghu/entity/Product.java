package com.app.raghu.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producttab")
public class Product {

	@Id
	@Column(name = "pid")
	private Integer prodId;

	@Column(name = "pcode")
	private String prodCode;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pidFk")
	private List<Model> mobs;

}
