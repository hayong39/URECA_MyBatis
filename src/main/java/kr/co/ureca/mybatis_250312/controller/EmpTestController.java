package kr.co.ureca.mybatis_250312.controller;

import kr.co.ureca.mybatis_250312.dto.EmpDTO;
import kr.co.ureca.mybatis_250312.service.EmpTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmpTestController {

    @Autowired
    private EmpTestService empTestService;

    @RequestMapping(value="/empAll", method= RequestMethod.GET)
    public String empSelectAll(){
        List<EmpDTO> list = empTestService.empSelectAll();
        System.out.println(list);
        return "hello";
    }

    @RequestMapping(value="/empByName", method= RequestMethod.GET)
    public String empSelectByEname(){
        EmpDTO dto = empTestService.empSelectByEname("ADAMS");
        System.out.println(dto);
        return "hello";
    }

    @RequestMapping(value="/empIns", method= RequestMethod.POST)
    public void empInsert(){

    }

    @RequestMapping(value="/empUp", method= RequestMethod.POST)
    public void empUpdate(){

    }

    @RequestMapping(value="/empDel", method= RequestMethod.GET)
    public void empDelete(){

    }
}
