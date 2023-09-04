package com.daum.daumboard.VO;

import lombok.Data;

@Data
public class BoardVO {
    private int no; //게시물번호
    private String subject; //게시물제목
    private String bcontent;    //게시물내용
    private String name;    //작성자
}

//작업순서
//1. VO로 변수 선언(완료)
//2. 화면디자인(W3Schools.com을 참고)(완료)
//3. Controller에 맵핑(연결) (완료)
//4. Mapper에 SQL 구성
//5. DAO 연동
//6. Service에서 DAO를 사용
//7. Controller에서 Service를 사용