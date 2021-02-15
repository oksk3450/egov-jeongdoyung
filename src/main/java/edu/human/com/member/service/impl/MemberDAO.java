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
	
	public EmployerInfoVO viewMember(String emplyr_id) throws Exception {
		//selectOne("쿼리ID","쿼리 매개변수=파라미터=인자값");
		return selectOne("memberMapper.viewMember", emplyr_id);
	}
	
	public int deleteMember(String emplyr_id) throws Exception {
		//affected된 row값이 반환됩니다.
		return delete("memberMapper.deleteMember", emplyr_id);
	}
	
	public void insertMember(EmployerInfoVO employerInfoVO) throws Exception {
		insert("memberMapper.insertMember", employerInfoVO);
	}
	
	public void updateMember(EmployerInfoVO employerInfoVO) throws Exception {
		update("memberMapper.updateMember", employerInfoVO);
	}
}
