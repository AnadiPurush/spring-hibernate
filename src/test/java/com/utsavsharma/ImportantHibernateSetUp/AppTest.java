package com.utsavsharma.ImportantHibernateSetUp;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author utsav
 */
public class AppTest {

	public static void main(String[] args) {

		System.out.println("Hello World!");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Dao dao = context.getBean("getDao", Dao.class);
		StudentEntity student = new StudentEntity(9, "Ankit sharma", "bhopal");

		try {
			dao.insert(student);
		} catch (Exception ex) {
			// Logger.getLogger(Testproject.class.getName()).log(Level.SEVERE, null, ex);
		}
		StudentEntity student1 = new StudentEntity();
		StudentEntity PrintDetails = dao.getStudentInfoById(3);
		System.out.println(PrintDetails);
		List<StudentEntity> printAll = dao.findAll();
		printAll.forEach(System.out::println);
		System.out.println(context.isActive());

		dao.deleteEntery(9);
		context.close();
		System.out.println(context.isActive());

	}
}
