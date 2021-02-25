package edu.human.com.board.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.human.com.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;//같은 패키지안에 있으면, import가 필요없음
	
	@Override
	public Integer delete_board(Integer nttId) throws Exception {
		// DAO호출
		return boardDAO.delete_board(nttId);
	}

	@Override
	public Integer delete_attach(String atchFileId) throws Exception {
		// DAO호출 역순으로 지움
		//bbs < attach < attachdetail
		int result=0;
		if(boardDAO.delete_attach_detail(atchFileId) > 0) {
			result =  boardDAO.delete_attach(atchFileId);
		}
		return result;
	}

}
