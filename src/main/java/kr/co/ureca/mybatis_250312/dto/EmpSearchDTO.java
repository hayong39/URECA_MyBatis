package kr.co.ureca.mybatis_250312.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmpSearchDTO {
    private String ename;
    private String job;
    private String deptno;
}
