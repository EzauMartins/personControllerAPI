package ezau.digitalinnovation.everis.proj.ezpersonalapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                         //IndicaControladorAcessadoAtravesDeAPIrest
@RequestMapping("/ApiEz/01/people")     //IndicaLocalDaRequisição(GET)
public class PersonController {

    @GetMapping
    public String getBook(){
        return "Test !!";
    }

}
