/**
 * 
 */
package com.pgichure.eprodhighschool.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprodhighschool.models.Student;


/**
 * @author pgichure
 * The Student DAO
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	/**
	 * Get students for a given class stream
	 * @param streamId
	 * @return List<Student>
	 */
	public List<Student> findByStreamId(Long streamId);
	
	/**
	 * Search students by name
	 * @param name
	 * @return List<Student>
	 */
	public List<Student> findAllByFirstNameOrLastName(String firstName, String lastName);

}
