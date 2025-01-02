package com.app.shivam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyCustomGenerator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {

		String prefix = "MY-PRD-";
		int random = new Random().nextInt();
		random = Math.abs(random);

		String date = new SimpleDateFormat("ddMMyy").format(new Date());

		return prefix + date + ":" + random;

		
	}

}
