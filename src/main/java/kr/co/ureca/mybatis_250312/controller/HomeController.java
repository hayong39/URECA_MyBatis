package kr.co.ureca.mybatis_250312.controller;

import kr.co.ureca.mybatis_250312.dto.EmpDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    //Autowired : 자동으로 묶어주는 것, SqlSession 만들어서 건네줌
    @Autowired
    private SqlSession sqlSession;

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String hello(){

        List<EmpDTO> list = sqlSession.selectList("MybatisSample.SampleEmp");
        System.out.println(list);
        // application.properties에서 작성한 prefix & suffix와 리턴값이 조합 : view resolver가 찾아야 하는 경로 및 파일을 의미
        // view resolver : view를 찾아주는 것
        // /WEB-INF/views/hello.jsp
        return "hello";
    }

}


/*
* @Controller, @Service, @Repository가 아니면 @Component annotation 사용
* */