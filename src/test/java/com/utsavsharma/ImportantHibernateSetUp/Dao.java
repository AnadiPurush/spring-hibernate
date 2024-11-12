package com.utsavsharma.ImportantHibernateSetUp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ${Utsav Sharma}
 */
@Repository

public class Dao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public StudentEntity insert(StudentEntity studentEntity) throws Exception {

		try {
			entityManager.merge(studentEntity);
		} catch (Exception e) {
			throw new ExpressionException("Something went wrong");
		}

		if (studentEntity == null) {
			throw new Exception("something went wrong");
		} else {
			System.out.println("Regestered sucessfully");
		}
		return null;
	}

	public StudentEntity getStudentInfoById(Integer Id) {
		return entityManager.find(StudentEntity.class, Id);
	}

	@SuppressWarnings("unchecked")
	public List<StudentEntity> findAll() {
		return entityManager.createNativeQuery("SELECT * FROM Student_Details;", StudentEntity.class).getResultList();
	}

	@Transactional
	public void deleteEntery(Integer Id) {
		StudentEntity studentRemove = entityManager.find(StudentEntity.class, Id);
		entityManager.remove(studentRemove);
	}
}
