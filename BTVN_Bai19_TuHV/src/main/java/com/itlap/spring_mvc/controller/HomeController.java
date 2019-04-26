package com.itlap.spring_mvc.controller;

import com.itlap.spring_mvc.handler.ReadUploadFile;
import com.itlap.spring_mvc.model.Dictionary;
import com.itlap.spring_mvc.model.ServiceResponse;
import com.itlap.spring_mvc.repository.DictionaryRepository;
import com.itlap.spring_mvc.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping
public class HomeController {

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Autowired
    ReadUploadFile readUploadFile;

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @GetMapping("/admin")
    public ModelAndView getAllUserTopics() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }
    @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView modelAndView = new ModelAndView();
        String errorMessage= "You are not authorized for the requested data.";
        modelAndView.addObject("errorMsg", errorMessage);
        modelAndView.setViewName("error");
        return modelAndView;
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Dictionary word, Model model) {
        if(word.getWord() == null){
            model.addAttribute("myword",word);
        }else{
            model.addAttribute("myword", word);
            model.addAttribute("listword", dictionaryService.findByWord(word.getWord(),0,10));
            System.out.println(dictionaryService.findByWord(word.getWord(),0,10));
        }
        return "home";
    }


    @RequestMapping(value = "/getWord", method = RequestMethod.GET)
    public ResponseEntity<Object> getWords(HttpServletRequest request) {
        Dictionary dictionary = dictionaryService.findByWord(request.getParameter("word"));
        ServiceResponse<Dictionary> response = new ServiceResponse<>("success", dictionary);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/getSuggestions", method = RequestMethod.GET)
    public ResponseEntity<Object> getSuggestions(HttpServletRequest request) {
        List<Dictionary> dictionaries = dictionaryService.findByWord(request.getParameter("word"),0,10);
        ServiceResponse<List<Dictionary>> response = new ServiceResponse<>("success", dictionaries);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @RequestMapping("/upload")
    public String upload(Model model,@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            try {
                BufferedReader reader = new BufferedReader( new InputStreamReader(file.getInputStream()));
                Map<String, String> dict = readUploadFile.ReadUploadFile(reader);
                for(Map.Entry<String, String> entry: dict.entrySet()){
                    dictionaryService.insertDictionary(entry.getKey(),entry.getValue());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("msg", "Successfully uploaded files ");
        return "admin";
    }


}