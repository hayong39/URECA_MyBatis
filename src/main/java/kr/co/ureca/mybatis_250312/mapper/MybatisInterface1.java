package kr.co.ureca.mybatis_250312.mapper;

import kr.co.ureca.mybatis_250312.dto.EmpDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MybatisInterface1 {
    @Select("SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno" +
            " FROM emp" +
            " ORDER BY ename")
    public List<EmpDTO> getAllEmp1();

    @Select("SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno" +
            " FROM emp" +
            " WHERE ename = #{ename}")
    public EmpDTO getEmpByEname1(@Param("ename") String ename);

    @Insert("INSERT INTO emp (ename, job, mgr, hiredate, sal, comm, deptno)" +
            " VALUES (#{param.ename}, #{param.job}, #{param.mgr}, now(), #{param.sal}, #{param.comm}, #{param.deptno})")
    public int insEmp1(@Param("param") EmpDTO dto);
}
