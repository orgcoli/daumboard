package com.daum.daumboard.Service;

import com.daum.daumboard.VO.BoardVO;

import java.util.List;
//DAO에 내용을 그대로 복사
public interface BoardService {
    public List<BoardVO> boardAllList() throws Exception;   //결과값이 여러개일때(List)
    public void boardInsert(BoardVO boardVO) throws Exception; //결과값이 없을 때 (void)
    public void boardDelete(int no) throws Exception;
    public void boardUpdate(BoardVO boardVO) throws Exception;
    public BoardVO boardOneList(int no) throws Exception;   //결과값이 하나일때
}
