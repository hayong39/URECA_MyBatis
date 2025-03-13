package kr.co.ureca.mybatis_250312.repository;

import kr.co.ureca.mybatis_250312.dto.EmpDTO;
import kr.co.ureca.mybatis_250312.dto.EmpSearchDTO;
import kr.co.ureca.mybatis_250312.mapper.MybatisInterface1;
import kr.co.ureca.mybatis_250312.mapper.MybatisInterface2;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpTestRepository {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private MybatisInterface1 interface1;

    @Autowired
    private MybatisInterface2 interface2;

    public List<EmpDTO> empSelectAll(){
        // 0. xml를 사용한 Mapper
//        List<EmpDTO> list = sqlSession.selectList("EmpTestMapper.empSelectAll");

        //1. Interface를 사용한 Mapper
//        List<EmpDTO> list = interface1.getAllEmp1();

        //2. Interface와 xml을 결합한 방식
        List<EmpDTO> list = interface2.getAllEmp2();

        return list;
    }

    public EmpDTO empSelectByEname(String ename){
        // 0. xml를 사용한 Mapper
//        EmpDTO dto = sqlSession.selectOne("EmpTestMapper.empSelectByEname", ename);

        //1. Interface를 사용한 Mapper
        EmpDTO dto = interface1.getEmpByEname1(ename);
        return dto;
    }

    public int empInsertList(ArrayList<EmpDTO> insList) {
        int successCnt = sqlSession.insert("EmpTestMapper.empInsertList", insList);
        return successCnt;
    }

    public int empInsert(EmpDTO dto){
        // 0. xml를 사용한 Mapper
//        int successCnt = sqlSession.insert("EmpTestMapper.empInsert", dto);

        //1. Interface를 사용한 Mapper
        int successCnt = interface1.insEmp1(dto);
//        System.out.println("empInsert-repository: "+dto.getEmpno());
        return successCnt;
    }

    public int empUpdate(EmpDTO dto){
        int successCnt = sqlSession.update("EmpTestMapper.empUpdate", dto);
        return successCnt;
    }

    public int empDelete(String empno){
        int successCnt = sqlSession.delete("EmpTestMapper.empDelete", empno);
        return successCnt;
    }


    public List<EmpDTO> selectIn(ArrayList<String> enameList) {
        List<EmpDTO> list = sqlSession.selectList("EmpTestMapper.selectIn", enameList);
        return list;
    }

    public List<EmpDTO> selectSearch(EmpSearchDTO dto) {
        List<EmpDTO> list = sqlSession.selectList("EmpTestMapper.selectSearch", dto);
        return list;
    }
}
