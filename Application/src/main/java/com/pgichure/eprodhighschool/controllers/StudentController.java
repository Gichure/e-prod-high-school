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
import org.springframework.web.bind.annotation.RestController;

import com.pgichure.eprodhighschool.dtos.StudentDto;
import com.pgichure.eprodhighschool.services.StudentServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 * The Student Controller
 *
 */
@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
@Api(tags = "Student", description = "Operations on student object")
public class StudentController {
	
	private final StudentServiceI service;

	@PostMapping
	@ApiOperation(value = "Save a student" ,notes = "Returns the object created.", response = StudentDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully created the record"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<StudentDto> save(@RequestBody StudentDto student){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(student));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get an student by ID", response = StudentDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the resource"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<StudentDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	@ApiOperation(value = "View a list of students", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<List<StudentDto>> get(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/search")
	@ApiOperation(value = "Get students by name", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<?> get(@RequestParam @ApiParam(value = "The name of the student to search") String name){
		List<StudentDto> students  = service.findByName(name);
		return students == null ?  ResponseEntity.ok().body("There is no student with the name "+name) : ResponseEntity.ok().body(students);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete an student by ID", response = StudentDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the student"),
			@ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<StudentDto> delete(
			@ApiParam(value = "The ID of the student to delete", required = true)
			@PathVariable("id") Long id) throws Exception{
		StudentDto student = service.delete(id);
		return ResponseEntity.ok().body(student);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update a student" ,notes = "Returns the updated student object udpated.", response = StudentDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully updated the student"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<StudentDto> update(
			@ApiParam(value = "The ID of the student to delete", required = true) Long id,
			@ApiParam(value = "Student details to be updated in database table", required = true)
			@RequestBody StudentDto student){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, student));
	}
}
