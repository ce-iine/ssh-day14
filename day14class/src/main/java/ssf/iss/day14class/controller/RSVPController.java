package ssf.iss.day14class.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rsvp")
public class RSVPController {

    @GetMapping
    public String getRSVP(@RequestParam MultiValueMap<String, String> form,  @RequestParam String name, Model model){
        System.out.printf("map GET: %s\n", form);
        System.out.printf("name: %s\n", name);

        model.addAttribute("name", form.getFirst("name"));
        return "thankyou";
    }

    @PostMapping
    // ModelAndView make it possible for a controller to return both model and view in a single return value.
    // It contains the model data (key-value pairs) that will be exposed to the view and also information about the view itself.
    //This class allows you to specify the view name along with the model data to be rendered by that view.
    // public ModelAndView postRSVP (@RequestBody MultiValueMap<String, String> form){

    //     System.out.printf("map POST: %s\n", form);

    //     String name = form.getFirst("name").trim().toLowerCase();
    //     ModelAndView mav = new ModelAndView();
        
    //     if (!"fred".equals(name)){
    //         mav.setViewName("whoareyou");
    //         mav.setStatus(HttpStatusCode.valueOf(400));
    //     } else {
    //         mav.setViewName("thankyou");
    //         mav.setStatus(HttpStatusCode.valueOf(201));
    //     }
        
    //     mav.addObject("name", name);
    //     return mav;
    // }

    
    //non ModelandView Way
    public String postRSVP (@RequestBody MultiValueMap<String, String> form, Model model){

        System.out.printf("map POST: %s\n", form);

        String name = form.getFirst("name").trim().toLowerCase();
        
        if (!"fred".equals(name)){
            model.addAttribute("name", name);
            return "whoareyou";
        } else {
            model.addAttribute("name", name);
            return "thankyou";
        }
    }
    
}
