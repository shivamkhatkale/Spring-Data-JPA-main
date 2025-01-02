package com.app.raghu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userTab")
public class User {

	@Id
	@Column(name = "uid")
	private Integer userId;
	private String userName;

	@ManyToOne
//	@JoinColumn(name="ridFK", unique = true, nullable=false)
	@JoinColumn(name = "	", unique = true)
	private Role rob;

}
