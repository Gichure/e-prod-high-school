/**
 * 
 */
package com.pgichure.eprodhighschool.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.pgichure.eprodhighschool.dtos.ClassStreamDto;
import com.pgichure.eprodhighschool.models.ClassStream;
import com.pgichure.eprodhighschool.repositories.ClassStreamRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 * The ClassStreamService service class
 *
 */
@Service
@RequiredArgsConstructor
public class ClassStreamService implements ClassStreamServiceI{
	
	private final ClassStreamRepository repository;
	
	private final ModelMapper modelMapper;

	@Override
	public ClassStreamDto save(ClassStreamDto dto) {
		ClassStream stream = modelMapper.map(dto, ClassStream.class);
		stream = repository.save(stream);
		return modelMapper.map(stream, ClassStreamDto.class);
	}

	@Override
	public ClassStreamDto findById(Long streamId) {
		Optional<ClassStream> stream = repository.findById(streamId);
		return stream.isPresent() ? modelMapper.map(stream.get(), ClassStreamDto.class) : null;
	}

	@Override
	public ClassStreamDto update(Long streamId, ClassStreamDto dto) {
		Optional<ClassStream> optionalStream = repository.findById(streamId);
		if(optionalStream.isPresent()) {
			ClassStream stream  = modelMapper.map(dto, ClassStream.class);
			stream.setId(streamId);
			stream = repository.save(stream);
			
			return modelMapper.map(stream, ClassStreamDto.class);
		}
		return null;
	}

	@Override
	public List<ClassStreamDto> findAll() {
		List<ClassStream> streams = repository.findAll();
		return streams.stream().map(stream -> modelMapper.map(stream, ClassStreamDto.class)).collect(Collectors.toList());
	}

	
}
