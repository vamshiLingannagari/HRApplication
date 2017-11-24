package com.diyaarya.HRApplication.RepositoryTest;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.diyaarya.HRApplication.Repository.HRRepository;
import com.diyaarya.HRApplication.model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HRRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private HRRepository hrRepository;

	@Test
	public void testFindByName() {
		//fail("Not yet implemented");
		//given
		Employee vam = new Employee("vam");
		entityManager.persist(vam);
		entityManager.flush();
		
		//when
		Employee found = hrRepository.findByName(vam.getName());
		
		//then
		assertThat(found.getName()).isEqualTo(vam.getName());
	}

}
