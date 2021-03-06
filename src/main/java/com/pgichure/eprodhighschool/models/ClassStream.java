/**
 * 
 */
package com.pgichure.eprodhighschool.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 * The Class stream entity/model
 */
@Data
@Entity
@Table(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassStream {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", unique = true, nullable = false)
	@NonNull
	private String name;
	
	@Column(name = "code", unique = true, nullable = false)
	@NonNull
	private String code;
	
}
