/**
 * 
 */
package com.pgichure.eprodhighschool.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.pgichure.eprodhighschool.services.StudentServiceI;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 * The Student Controller
 *
 */
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentController {
	
	private final StudentServiceI service;

}
