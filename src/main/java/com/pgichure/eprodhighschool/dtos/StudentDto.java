/**
 * 
 */
package com.pgichure.eprodhighschool.dtos;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 * The Student entity class
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Student", description = "The Student details")
public class StudentDto {
	
	@ApiModelProperty(name = "id", notes = "The primary ID")
	private Long id;

	@ApiModelProperty(name = "firstName", notes = "The student first name", required = true)
	private String firstName;
	
	@ApiModelProperty(name = "lastName", notes = "The student last name", required = true)
	private String lastName;
	
	@ApiModelProperty(name = "registrationNumber", notes = "The student registration number", required = true)
	private String registrationNumber;
	
	@ApiModelProperty(name = "dateOfBirth", notes = "The date of birth", required = true)
	private Date dateOfBirth;
	
	@ApiModelProperty(name = "stream", notes = "The stream details of the student", required = true)
	private ClassStreamDto stream;
	
}
