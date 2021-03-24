/*
 * With the @SpringBootTest annotation, Spring Boot provides a convenient way
 *  to start up an application context to be used in a test.
 */

package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
