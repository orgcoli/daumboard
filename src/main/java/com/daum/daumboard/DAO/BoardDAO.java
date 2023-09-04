package com.daum.daumboard.DAO;

import com.daum.daumboard.VO.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//id명 = 메소드명 동일하게 resultType, parameterType(입력값) 참고해서 완성

@Mapper
public interface BoardDAO {
/*
    <select id="boardAllList" resultType="BoardVO">
    <insert id="boardInsert">
    <delete id="boardDelete">
    <update id="boardUpdate">
    <select id="boardOneList" resultType="BoardVO">
    id이름으로 메소드를 생성
*/
    public List<BoardVO> boardAllList() throws Exception;   //결과값이 여러개일때(List)
    public void boardInsert(BoardVO boardVO) throws Exception; //결과값이 없을 때 (void)
    public void boardDelete(int no) throws Exception;
    public void boardUpdate(BoardVO boardVO) throws Exception;
    public BoardVO boardOneList(int no) throws Exception;   //결과값이 하나일때
}
