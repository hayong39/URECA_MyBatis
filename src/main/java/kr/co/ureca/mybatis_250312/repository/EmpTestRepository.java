package kr.co.ureca.mybatis_250312.repository;

import kr.co.ureca.mybatis_250312.dto.EmpDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpTestRepository {

    @Autowired
    private SqlSession sqlSession;

    public List<EmpDTO> empSelectAll(){
        List<EmpDTO> list = sqlSession.selectList("EmpTestMapper.empSelectAll");
        return list;
    }

    public EmpDTO empSelectByEname(String ename){
        EmpDTO dto = sqlSession.selectOne("EmpTestMapper.empSelectByEname", ename);
        return dto;
    }

    public void empInsert(){

    }

    public void empUpdate(){

    }

    public void empDelete(){

    }
}
