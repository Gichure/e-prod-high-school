/**
 * 
 */
package com.pgichure.eprodhighschool.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

/**
 * @author Hp
 *
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping
    public String product(Model model) {
        return "index";
    }
    
}
