package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.TipsDao;
import bo.edu.ucb.ingsoft.demorest.dto.Tips;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionTips {

    @Autowired
    TipsDao tipsDao;
    public List<Tips> findAllTips(){
        return tipsDao.findAllTips();
    }



}
