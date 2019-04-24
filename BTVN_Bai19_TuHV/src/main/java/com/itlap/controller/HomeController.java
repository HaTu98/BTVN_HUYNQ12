package com.itlap.controller;

import com.itlap.model.VieToEng;
import com.itlap.repository.VieToEngRepository;
import com.itlap.service.impl.VieToEngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@ComponentScan()
public class HomeController {

    @Autowired
    VieToEngService vieToEngService;

    @Autowired
    VieToEngRepository vieToEngRepository;

//    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
//    public String helloWorld(Model model){
//        model.addAttribute("messages", vieToEngService.findByVie("A", 0,10));
//        return "message/list";
//    }




    List<VieToEng> vieToEngs ;
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

//    @GetMapping(value = "/search")
//    public String search (Model model, VieToEng VieToEng) {
//
//        vieToEngs = vieToEngRepository.findAll();
//        List<String> myWord = vieToEngs.stream()
//                .map(i->i.getVie())
//                .collect(Collectors.toList());
//        model.addAttribute("myWord", myWord );
//        model.addAttribute("searchWord", VieToEng);
//        System.out.println(VieToEng.getVie());
//        return "search";
//    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(VieToEng world, Model model) {
        System.out.println(world);
            model.addAttribute("VieToEng", vieToEngService.findByVie(world.getVie(), 0, 10));
        return "search";
    }

//    @GetMapping(value = "/search")
//    public String search (Model model, VieToEng vieToEng) {
//
//        vieToEngs = vieToEngRepository.findAll();
//        List<String> myWord = vieToEngs.stream()
//                .map(i->i.getVie())
//                .collect(Collectors.toList());
//        model.addAttribute("myWord", myWord );
//        model.addAttribute("searchWord", vieToEng);
//        System.out.println(vieToEng.getEng());
//        return "index";
//    }
}
