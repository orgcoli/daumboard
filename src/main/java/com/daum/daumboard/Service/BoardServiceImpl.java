package com.daum.daumboard.Service;

import com.daum.daumboard.DAO.BoardDAO;
import com.daum.daumboard.VO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//DAO를 사용
@Service
public class BoardServiceImpl implements BoardService {
    //CTRL-I를 눌러서 BoardService의 메소드를 추가
    //작업할 DAO를 지정
    @Autowired
    BoardDAO boardDAO;

    @Override
    public List<BoardVO> boardAllList() throws Exception {
        return boardDAO.boardAllList();
    }

    @Override
    public void boardInsert(BoardVO boardVO) throws Exception {
        boardDAO.boardInsert(boardVO);
    }

    @Override
    public void boardDelete(int no) throws Exception {
        boardDAO.boardDelete(no);
    }

    @Override
    public void boardUpdate(BoardVO boardVO) throws Exception {
        boardDAO.boardUpdate(boardVO);
    }

    @Override
    public BoardVO boardOneList(int no) throws Exception {
        return boardDAO.boardOneList(no);
    }
}
