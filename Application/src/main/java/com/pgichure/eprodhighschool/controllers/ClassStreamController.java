/**
 * 
 */
package com.pgichure.eprodhighschool.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.pgichure.eprodhighschool.services.ClassStreamServiceI;

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

}
