/**
 * 
 */
package com.pgichure.eprodhighschool.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 * The Class stream entity/model
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Class Stream", description = "Class stream")
public class ClassStreamDto {

	@ApiModelProperty(name = "id", notes = "The primary ID")
	private Long id;
	
	@ApiModelProperty(name = "name", notes = "The class name", required = true, example = "Form 1 A")
	private String name;
	
	@ApiModelProperty(name = "code", notes = "The class code", required = true, example = "F1A")
	private String code;
	
}
