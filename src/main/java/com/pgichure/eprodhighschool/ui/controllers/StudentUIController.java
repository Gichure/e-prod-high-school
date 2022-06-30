/**
 * 
 */
package com.pgichure.eprodhighschool.ui.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pgichure.eprodhighschool.dtos.StudentDto;
import com.pgichure.eprodhighschool.dtos.StudentDto;
import com.pgichure.eprodhighschool.services.StudentServiceI;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 * The Student UI controller
 *
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/students")
public class StudentUIController {

	private final StudentServiceI service;
	
	@RequestMapping("/list")
    public String product(Model model) {
        model.addAttribute("students", service.findAll());
        return "students/list";
    }
	
	@RequestMapping("/create")
    public String create(Model model) {
        return "students/create";
    }

    @RequestMapping("/save")
    public String save(@RequestBody StudentDto dto) {
        dto = service.save(dto);
        return "redirect:/students/view/" + dto.getId();
    }

    @RequestMapping("/view/{id}")
    public String show(@PathVariable Long id, Model model) {
    	StudentDto student = service.findById(id);
        model.addAttribute("student", student);
        return "students/view";
    }
    
    @RequestMapping("/view/{id}/students")
    public String viewStudents(@PathVariable Long id, Model model) {
    	StudentDto student = service.findById(id);
        model.addAttribute("student", student);
        return "students/view";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id) {
    	service.delete(id);
        return "redirect:/students/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
    	StudentDto student = service.findById(id);
        model.addAttribute("student", student);
        return "students/edit";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody StudentDto dto) {
    	dto = service.update(id, dto);
        return "redirect:students/show/" + dto.getId();
    }
	
}
