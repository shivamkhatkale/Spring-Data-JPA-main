package com.app.raghu.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.app.raghu.entity.Role;
import com.app.raghu.entity.User;
import com.app.raghu.repository.RoleRepository;
import com.app.raghu.repository.UserRepository;

@Component
public class TestDataRunner implements CommandLineRunner {

	@Autowired
	private RoleRepository repo;

	@Autowired
	private UserRepository urepo;

	@Override
	public void run(String... args) throws Exception {

		Role r1 = new Role(11, "ADMIN");
		Role r2 = new Role(12, "GUEST");

		repo.saveAll(List.of(r1, r2));

		User u1 = new User(12, "Shivam", r1);
		User u2 = new User(13, "Rushikesh", r2);

		urepo.saveAll(List.of(u1, u2));

	}

}
