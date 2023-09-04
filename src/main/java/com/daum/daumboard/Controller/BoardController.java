package com.daum.daumboard.Controller;

import com.daum.daumboard.Service.BoardService;
import com.daum.daumboard.VO.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//View와 Service의 연계처리
@Controller
public class BoardController {
    //로그로 정보출력
    private Logger logger = LoggerFactory.getLogger(BoardController.class);
    @Autowired
    BoardService boardService;  //서비스 주입하고 사용할 메소드를 지정

    //get과 post 구분없이 맵핑처리
    //http://localhost:8080/
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("인덱스 페이지 처리");
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    //목록처리와 함께 화면출력
    //http://localhost:8080/board-list
    @GetMapping("/board-list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("목록 페이지 처리");
        List<BoardVO> lists = boardService.boardAllList();
        ModelAndView mav = new ModelAndView("/board/list");
        mav.addObject("lists", lists);  //""이름이 html에서 ${xxx.
        return mav;
    }

    //삽입 화면출력
    @GetMapping("/board-insert")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("삽입 페이지 처리");
        //데이터베이스 처리가 없어용
        ModelAndView mav = new ModelAndView("/board/insert");
        return mav;
    }
    //삽입내용을 데이터베이스에 처리
    @PostMapping("/board-insert")
    public ModelAndView indexProc(@ModelAttribute("BoardVO") BoardVO boardVO, HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("삽입한 내용을 데이터베이스에 처리");
        boardService.boardInsert(boardVO);
        ModelAndView mav = new ModelAndView("redirect:/board-list");    //맵핑이름
        return mav;
    }

    //데이터베이스에서 수정할 내용을 읽어서 수정화면으로 출력
    @GetMapping("/board-update")
    public ModelAndView update(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("데이터베이스에서 수정할 내용을 읽어서 수정페이지로 이동");
        BoardVO data = boardService.boardOneList(no);

        ModelAndView mav = new ModelAndView("/board/update");
        mav.addObject("data", data);
        return mav;
    }
    //수정화면에서 입력한 내용을 데이터베이스에 처리
    @PostMapping("/board-update")
    public ModelAndView updateproc(@ModelAttribute("BoardVO") BoardVO boardVO, HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("데이터베이스에 수정 처리 후 목록페이지로 이동");
        boardService.boardUpdate(boardVO);
        ModelAndView mav = new ModelAndView("redirect:/board-list");
        return mav;
    }

    //데이터베이스에 지정자료를 삭제처리
    @GetMapping("/board-delete")
    public ModelAndView delete(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("데이터베이스에 삭제 후 목록페이지로 이동");
        boardService.boardDelete(no);
        ModelAndView mav = new ModelAndView("redirect:/board-list");
        return mav;
    }
}
