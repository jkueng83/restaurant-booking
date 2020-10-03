package com.campus.restaurant.booking;

import com.campus.restaurant.booking.model.Table;
import com.campus.restaurant.booking.repository.TableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantBookingApplicationTests {

	@Autowired
	private TableRepository tableRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void countTablesTest() {
		long count = tableRepository.count();
		assertTrue(count > 0);
	}

	@Test
	void findTableByNameTest() {
		List<Table> list =  tableRepository.findByPersonName("Paul");
		assertTrue(list.size() > 0);
		Table table = list.get(0);
		assertEquals(table.getNumberOfPersons(), 21);

	}


	@Test
	void myFunnyTest() {
		Table table = tableRepository.gibMirAlleByName("Paul");
		assertNotNull(table);
	}

	@Test
	void find_by_number_of_persons() {
		List<Table> tableList = tableRepository.findByNumberOfPersonsGreaterThan(5);
		System.out.println(tableList.size());
		assertTrue(tableList.size() > 1);
	}

}
