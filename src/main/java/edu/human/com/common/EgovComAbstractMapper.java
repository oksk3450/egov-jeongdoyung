package edu.human.com.common;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * EgovComAbstractMapper클래스는 sqlSession템플릿을 DAO클래스에서 직접 호출하지않고 
 * 전자정부에서 제공한 EgovAbstractMapper(마이바티스용)클래스를 상속받아서 생성한
 * 개발자(사) 클래스를 사용해서 쿼리템플릿을 재정의 함.
 * 추상클래스특징 : (예, 자동차(소형,중형,대형) )
 * Abstract클래스 특징: new 키워드로 인스턴스 실행클래스를 만들수 없다.
 * 상속을 통해서 클래스의 메서드를 실행 가능함.
 * 오버라이드해서 전자정부에서 제공한 EgovAbstractMapper 추상클래스에서 정의된 명세를
 * 아래 클래스 재정의(오버라이드)해서 메서드를 구현하게 됨.
 * 추상클래스를 만드는 목적 : 멤버변수 또는 멤버메서드를 규격화 함.
 * @author 정도영
 *
 */
public abstract class EgovComAbstractMapper extends EgovAbstractMapper {
	//private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Resource(name="egov.sqlSession")
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
	
	@Override
	public int delete(String queryId) {
		return getSqlSession().delete(queryId);
	}

	@Override
	public int delete(String queryId, Object parameterObject) {
		return getSqlSession().delete(queryId, parameterObject);
	}
	
	@Override
	public int insert(String queryId) {
		return getSqlSession().insert(queryId);
	}
	@Override
	public int insert(String queryId, Object parameterObject) {
		return getSqlSession().insert(queryId, parameterObject);
	}
	@Override
	public <E> List<E> selectList(String queryId, Object parameterObject) {
		return getSqlSession().selectList(queryId, parameterObject);
	}
	@Override
	public <E> List<E> selectList(String queryId) {
		return getSqlSession().selectList(queryId);
	}
	
	@Override
	public <T> T selectOne(String queryId) {
		return getSqlSession().selectOne(queryId);
	}

	@Override
	public <T> T selectOne(String queryId, Object parameterObject) {
		return getSqlSession().selectOne(queryId, parameterObject);
	}
	
	@Override
	public int update(String queryId) {
		return getSqlSession().update(queryId);
	}
	@Override
	public int update(String queryId, Object parameterObject) {
		return getSqlSession().update(queryId, parameterObject);
	}
	
	
	@Override
	public <E> List<E> selectList(String queryId, Object parameterObject, RowBounds rowBounds) {
		return getSqlSession().selectList(queryId, parameterObject, rowBounds);
	}

	/**
	 * 페이징범위계산 : pageIndex(선택한페이지)와 pageSize(=limit,1페이지당 보여줄 갯수) 2개 값을 매개변수로 받아서 
	 * 계산결과1 : skipResults = pageIndex * pageSize = 1*10, 2*10, 3*10 선택한 페이지까지 검색된 개수
	 * 계산결과1 : 화면에 출력할 내용중 시작할 번호 = offset
	 * 계산결과2 : maxResults = RowBounds(선택된 페이지 * 1페이지당 보여줄개수) + 1페이지당 보여줄개수
	 * 계산결과2 : maxResults = 화면에 출력할 내용중 끝번호
	 */
	@Override
	public List<?> listWithPaging(String queryId, Object parameterObject, int pageIndex, int pageSize) {
		int offset = (pageIndex-1) * pageSize;
		RowBounds rowBounds = new RowBounds(offset, pageSize);//(시작인덱스번호, 꺼내올개수)
		return getSqlSession().selectList(queryId, parameterObject, rowBounds);
	}
	
}
