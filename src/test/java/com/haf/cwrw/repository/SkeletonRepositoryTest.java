package com.haf.cwrw.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.haf.cwrw.model.SkeletonModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class SkeletonRepositoryTest {

	@Autowired
	private SessionFactory sessionFactory;
	private Session currentSession;

	@Before
	public void openSession() {
		currentSession = sessionFactory.getCurrentSession();
	}

	@Test
	public void shouldHaveASessionFactory() {
		assertNotNull(sessionFactory);
	}

	@Test
	public void shouldHaveNoObjectsAtStart() {
		List<?> results = currentSession.createQuery("from SkeletonModel").list();
		assertTrue(results.isEmpty());
	}

	@Test
	public void shouldBeAbleToPersistAnObject() {
		assertEquals(0, currentSession.createQuery("from SkeletonModel").list().size());
		SkeletonModel jobUser = new SkeletonModel("Bar");
		currentSession.persist(jobUser);
		currentSession.flush();
		assertEquals(1, currentSession.createQuery("from SkeletonModel").list().size());
	}

	@Test
	public void shouldBeABleToQueryForObjects() {
		shouldBeAbleToPersistAnObject();

		assertEquals(1,
				currentSession.createQuery("from SkeletonModel where name = 'Bar'")
						.list().size());
		assertEquals(0,
				currentSession.createQuery("from SkeletonModel where name = 'Baz'")
						.list().size());
		
		List<SkeletonModel> skeletons = currentSession.createQuery("from SkeletonModel where name = 'Bar'").list();
		
		System.out.println("working ");
		for(SkeletonModel skeleton:skeletons){
			System.out.println(skeleton.getName());
		}
	}
}
