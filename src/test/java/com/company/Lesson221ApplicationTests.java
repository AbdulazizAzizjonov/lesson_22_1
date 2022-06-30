package com.company;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class Lesson221ApplicationTests {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		System.out.println(b.encode("alish123"));
	}

}
