/**
 * 
 */
package com.pgichure.eprodhighschool.services;

import java.util.List;

import com.pgichure.eprodhighschool.dtos.ClassStreamDto;

/**
 * @author pgichure
 * The ClassStream Service Interface
 *
 */
public interface ClassStreamServiceI {

	/**
	 * Save ClassStream
	 * @param stream
	 * @return
	 */
	public ClassStreamDto save(ClassStreamDto stream);
	
	/**
	 * Find ClassStream by ID
	 * @param streamId
	 * @return
	 */
	public ClassStreamDto findById(Long streamId);
	
	/**
	 * Update ClassStream using ID
	 */
	public ClassStreamDto update(Long streamId, ClassStreamDto stream);
	
	/**
	 * Find All ClassStreams
	 * @return
	 */
	public List<ClassStreamDto> findAll();

	/**
	 * Delete stream by ID
	 * @param id
	 * @return
	 */
	public ClassStreamDto delete(Long id);
	
}
