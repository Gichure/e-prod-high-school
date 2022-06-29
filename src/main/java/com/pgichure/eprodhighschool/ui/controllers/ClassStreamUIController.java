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

import com.pgichure.eprodhighschool.dtos.ClassStreamDto;
import com.pgichure.eprodhighschool.dtos.StudentDto;
import com.pgichure.eprodhighschool.services.ClassStreamServiceI;
import com.pgichure.eprodhighschool.services.StudentServiceI;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 * The class controller
 *
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/classes")
public class ClassStreamUIController {

	private final ClassStreamServiceI service;
	
	private final StudentServiceI studentService;
	
	@RequestMapping("/list")
    public String product(Model model) {
        model.addAttribute("classes", service.findAll());
        return "classes/list";
    }
	
	@RequestMapping("/create")
    public String create(Model model) {
        return "classes/create";
    }

    @RequestMapping("/save")
    public String save(@RequestBody ClassStreamDto dto) {
        dto = service.save(dto);
        return "redirect:/classes/view/" + dto.getId();
    }

    @RequestMapping("/view/{id}")
    public String show(@PathVariable Long id, Model model) {
    	ClassStreamDto classStream = service.findById(id);
        List<StudentDto> students = studentService.findByStreamId(id);
        model.addAttribute("class", classStream);
        model.addAttribute("students", students);
        return "classes/view";
    }
    
    @RequestMapping("/view/{id}/students")
    public String viewStudents(@PathVariable Long id, Model model) {
    	ClassStreamDto classStream = service.findById(id);
    	List<StudentDto> students = studentService.findByStreamId(id);
        model.addAttribute("class", classStream);
        model.addAttribute("students", students);
        return "classes/view";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id) {
    	service.delete(id);
        return "redirect:/classes/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
    	ClassStreamDto classStream = service.findById(id);
        model.addAttribute("class", classStream);
        return "classes/edit";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody ClassStreamDto dto) {
    	dto = service.update(id, dto);
        return "redirect:classes/view/" + dto.getId();
    }
}
