package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionTips;

import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demorest.dto.Tips;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class TipsController {
    @Autowired
    public DataSource dataSource;

    @Autowired
    private GestionTips gestionTips;

    @GetMapping(path = "/tips")
    public ResponseDto findAllTips(){
        return new ResponseDto(true,gestionTips.findAllTips(),null);


    }



}
