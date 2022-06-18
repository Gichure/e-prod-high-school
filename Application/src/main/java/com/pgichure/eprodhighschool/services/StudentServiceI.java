/**
 * 
 */
package com.pgichure.eprodhighschool.services;

import java.util.List;

import com.pgichure.eprodhighschool.dtos.StudentDto;

/**
 * @author pgichure
 * The Student service Interface
 *
 */
public interface StudentServiceI {
	
	/**
	 * Save a student
	 * @param student
	 * @return
	 */
	public StudentDto save(StudentDto student);
	
	/**
	 * Find a student by ID
	 * @param studentId
	 * @return
	 */
	public StudentDto findById(Long studentId);
	
	/**
	 * Update a student by student ID
	 * @param studentId
	 * @param student
	 * @return
	 */
	public StudentDto update(Long studentId, StudentDto student);
	
	/**
	 * Find all students
	 * @return
	 */
	public List<StudentDto> findAll();
	
	/**
	 * Find students in a give stream
	 * @param streamId
	 * @return
	 */
	public List<StudentDto> findByStreamId(Long streamId);
	
	/**
	 * Find student by name
	 * @param name
	 * @return
	 */
	public List<StudentDto> findByName(String name);
	
}
