package org.springframework.samples.petclinic.care;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visit/{visit_id}/care")
public class CareController {
    @Autowired
    CareService careService;

    @GetMapping("/create")
    public String create(ModelMap model){
         
        return null;
    }
}
