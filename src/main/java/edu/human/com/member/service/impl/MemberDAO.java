package edu.human.com.member.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.human.com.common.EgovComAbstractMapper;
import edu.human.com.member.service.EmployerInfoVO;

/**
 * egov에서 DAO는 sqlSession템플릿을 바로 접근하지않고,
 * EgovAbstractMapper클래스를 상속받아서 DAO구현 메서드를 사용.
 * @author 정도영
 *
 */
@Repository
public class MemberDAO extends EgovComAbstractMapper {
	
	public List<EmployerInfoVO> selectMember() throws Exception {
		
		return selectList("memberMapper.selectMember");
	}
}
