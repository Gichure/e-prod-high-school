/**
 * 
 */
package com.pgichure.eprodhighschool.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.pgichure.eprodhighschool.dtos.StudentDto;
import com.pgichure.eprodhighschool.models.Student;
import com.pgichure.eprodhighschool.repositories.StudentRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 * The Student service implementation
 */
@Service
@RequiredArgsConstructor
public class StudentService implements StudentServiceI {
	
	private final StudentRepository repository;
	
	private final ModelMapper modelMapper;

	@Override
	public StudentDto save(StudentDto dto) {
		Student student = modelMapper.map(dto, Student.class);
		student = repository.save(student);
		return modelMapper.map(student, StudentDto.class);
	}

	@Override
	public StudentDto findById(Long studentId) {
		Optional<Student> student = repository.findById(studentId);
		return student.isPresent() ? modelMapper.map(student.get(), StudentDto.class) : null;
	}

	@Override
	public StudentDto update(Long studentId, StudentDto dto) {
		Optional<Student> optionalStudent = repository.findById(studentId);
		if(optionalStudent.isPresent()) {
			Student student  = modelMapper.map(dto, Student.class);
			student.setId(studentId);
			student = repository.save(student);
			
			return modelMapper.map(student, StudentDto.class);
		}
		return null;
	}

	@Override
	public List<StudentDto> findAll() {
		List<Student> students = repository.findAll();
		return students.stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<StudentDto> findByStreamId(Long streamId) {
		List<Student> students = repository.findByStreamId(streamId);
		return students.stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<StudentDto> findByName(String name) {
		List<Student> students = repository.findAllByFirstNameOrLastName(name, name);
		return students.stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
	}
	
	@Override
	public StudentDto delete(Long id) {
		Optional<Student> student = repository.findById(id);
		repository.deleteById(id);
		return modelMapper.map(student.get(),StudentDto.class);
	}

}
