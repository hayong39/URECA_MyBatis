package kr.co.ureca.mybatis_250312.controller;

import kr.co.ureca.mybatis_250312.dto.EmpDTO;
import kr.co.ureca.mybatis_250312.dto.EmpSearchDTO;
import kr.co.ureca.mybatis_250312.service.EmpTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
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

    @RequestMapping(value="/empInsList", method= RequestMethod.POST)
    public String empInsertList(){
        EmpDTO dto1 = new EmpDTO(null, "YOUNG", "CLERK", null, null, "1000", "200", "40");
        EmpDTO dto2 = new EmpDTO(null, "YOUNG", "CLERK", null, null, "1000", "200", "40");
        EmpDTO dto3 = new EmpDTO(null, "YOUNG", "CLERK", null, null, "1000", "200", "40");
        ArrayList<EmpDTO> insList = new ArrayList<>();
        insList.add(dto1);
        insList.add(dto2);
        insList.add(dto3);
        int successCnt = empTestService.empInsertList(insList);
        System.out.println("empInsertList-controller-successCnt: "+ successCnt);
        return "hello";
    }

    @RequestMapping(value="/empIns", method= RequestMethod.POST)
    public String empInsert(){
        EmpDTO dto = new EmpDTO(null, "YOUNG", "CLERK", null, null, "1000", "200", "40");
        int successCnt = empTestService.empInsert(dto);
        System.out.println("empInsert-controller-successCnt: "+ successCnt);
        return "hello";
    }

    @RequestMapping(value="/empUp", method= RequestMethod.POST)
    public String empUpdate(){
        EmpDTO dto = new EmpDTO("7935", "HAYOUNG", "ANALYST", null, null, "2000", "200", "40");
        int successCnt = empTestService.empUpdate(dto);
        System.out.println("empUpdate-controller-successCnt: "+ successCnt);
        return "hello";
    }

    @RequestMapping(value="/selectSearch", method= RequestMethod.GET)
    public String selectSearch(){
        EmpSearchDTO dto1 = new EmpSearchDTO("SMITH", null, null);
        List<EmpDTO> list1 = empTestService.selectSearch(dto1);
        System.out.println("selectSearch-controller-list1: " + list1);
        EmpSearchDTO dto2 = new EmpSearchDTO(null, "MANAGER", null);
        List<EmpDTO> list2 = empTestService.selectSearch(dto2);
        System.out.println("selectSearch-controller-list2: " + list2);
        EmpSearchDTO dto3 = new EmpSearchDTO(null, null, "10");
        List<EmpDTO> list3 = empTestService.selectSearch(dto3);
        System.out.println("selectSearch-controller-list3: " + list3);
        return "hello";
    }

    @RequestMapping(value="/selectIn", method= RequestMethod.GET)
    public String selectIn(){
        ArrayList<String> enameList = new ArrayList<>();
        enameList.add("HAYOUNG");
        enameList.add("ADAMS");
        enameList.add("MILLER");
        List<EmpDTO> list = empTestService.selectIn(enameList);
        System.out.println("selectIn-controller-successCnt: "+ list);
        return "hello";
    }

    @RequestMapping(value="/empDel", method= RequestMethod.GET)
    public String empDelete(){
        int successCnt = empTestService.empDelete("7566");
        System.out.println("empDelete-controller-successCnt: "+ successCnt);
        return "hello";
    }
}
