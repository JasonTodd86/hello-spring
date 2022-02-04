package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //I want this to handle requests that start at /hello. So I put the string in parentheses.
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //lives at /hello/adios
    @GetMapping("adios")
    public String adios(){
        return "Adios, Spring!";
    }

    //lives at /hello/hello
    //I want this to handle requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!!";
    }

    //I want this handler to handle requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!!";
    }


    public static String createMessage(@RequestParam String name, @RequestParam String language){

        String greeting = "";

        if(name == null){
            return name = "World";
        }
        if(language.equals("english")){
            greeting = "Hello";
        } else if (language.equals("french")){
            greeting = "Bonjour";
        } else if (language.equals("italian")){
            greeting = "Bongiorno";
        } else if (language.equals("german")){
            greeting = "Holla";
        } else if (language.equals("romanian")){
            greeting = "buna ziua";
        }
        return greeting + "" + name;
    }


    //lives at /hello/form
    @RequestMapping(value="form", method= RequestMethod.GET)
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //tells it to submit a request to /hello
                "<input type='text' name='name'/>" +
                "<select name = 'language'>" +
                "<option value =''</option>" +
                "<option value ='english'>English</option>" +
                "<option value ='french'>French</option>" +
                "<option value ='italian'>Italian</option>" +
                "<option value ='german'>German</option>" +
                "<option value ='romanian'>Romanian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


//
//
//    @GetMapping("form")
//    public String helloForm(){
//        return "<html>" +
//                "<body>" +
//                "<form action='hello' method='post'>" + //tells it to submit a request to /hello
//                "<input type='text' name='name'>" +
//                "<label for='language-select'>Choose a language:</label>" +
//                "<select name='language' id='language-select'>" +
//                    "<option value=''>--Please choose an option--</option>" +
//                        "<option value='Bonjour'>French</option>" +
//                        "<option value='Hola'>Spanish</option>" +
//                        "<option value='Hallo'>German</option>" +
//                "</select>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }


}
