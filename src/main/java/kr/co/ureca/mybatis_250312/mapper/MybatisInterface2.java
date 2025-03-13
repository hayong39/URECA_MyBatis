package kr.co.ureca.mybatis_250312.mapper;

import kr.co.ureca.mybatis_250312.dto.EmpDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisInterface2 {
    public List<EmpDTO> getAllEmp2();
}

/*
* interface와 xml을 결합한 방식
*
*/
