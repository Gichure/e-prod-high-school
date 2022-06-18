/**
 * 
 */
package com.pgichure.eprodhighschool.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pgichure.eprodhighschool.dtos.ClassStreamDto;
import com.pgichure.eprodhighschool.dtos.StudentDto;
import com.pgichure.eprodhighschool.services.ClassStreamServiceI;
import com.pgichure.eprodhighschool.services.StudentServiceI;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 * The ClassStream controller
 *
 */
@RequestMapping(value = "/classes")
@RequiredArgsConstructor
public class ClassStreamController {
	
	private final ClassStreamServiceI service;
	
	private final StudentServiceI studentService;

	@PostMapping
	@ApiOperation(value = "Save a class" ,notes = "Returns the object created.", response = ClassStreamDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully created the record"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<ClassStreamDto> save(@RequestBody ClassStreamDto stream){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(stream));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get stream by ID", response = ClassStreamDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the resource"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<ClassStreamDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	@ApiOperation(value = "View a list of streams", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<List<ClassStreamDto>> get(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a stream by ID", response = ClassStreamDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the stream"),
			@ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<ClassStreamDto> delete(
			@ApiParam(value = "The ID of the stream to delete", required = true)
			@PathVariable("id") Long id) throws Exception{
		ClassStreamDto stream = service.delete(id);
		return ResponseEntity.ok().body(stream);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update a stream" ,notes = "Returns the updated stream object updated.", response = ClassStreamDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully updated the stream"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<ClassStreamDto> update(
			@ApiParam(value = "The ID of the stream to delete", required = true) Long id,
			@ApiParam(value = "Stream details to be updated in database table", required = true)
			@RequestBody ClassStreamDto stream){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, stream));
	}
	
	@GetMapping("/{id}/students")
	@ApiOperation(value = "View a list of students for a stream", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<?> getStudents(@PathVariable @ApiParam(value = "The ID of the stream", required = true) Long streamId){
		List<StudentDto> students  = studentService.findByStreamId(streamId);
		return students == null ?  ResponseEntity.ok().body("There is no students for the stream ID "+streamId) : ResponseEntity.ok().body(students);
	}
}
