package uz.pdp.spring_boot_security_web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.spring_boot_security_web.service.SubjectService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/{name}")
    public String topic(
            Model model,
            @PathVariable String name
    ){
        model.addAttribute("subject",subjectService.getByTitle(name));
        return "subject";
    }





}
