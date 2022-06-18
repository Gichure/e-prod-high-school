/**
 * 
 */
package com.pgichure.eprodhighschool.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 * The Student entity class
 *
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "students")
@NoArgsConstructor
@Builder
public class Student {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", unique = true, nullable = false)
	@NonNull
	private String firstName;
	
	@Column(name = "last_name")
	@NonNull
	private String lastName;
	
	@Column(name = "registration_no", unique = true, nullable = false)
	@NonNull
	private String registrationNumber;
	
	@Column(name = "dob", nullable = false)
	@NonNull
	private Date dateOfBirth;
	
	@ManyToOne
	@JoinColumn(name = "class_id", nullable = false)
	@NonNull
	private ClassStream stream;
	
}
