package notice.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;
import notice.model.vo.Pagination;

public interface NoticeStore {
	/**
	 * 공지사항 등록 Store
	 * 
	 * @param sqlSession
	 * @param notice
	 * @return int
	 */
	public int insertNotice(SqlSession sqlSession, Notice notice);

	/**
	 * 공지사항 목록 조회 Store
	 * 
	 * @param sqlSession
	 * @return
	 */
	public List<Notice> selectAllNotice(SqlSession sqlSession, Pagination pageNation);

	/**
	 * 공지사항 목록 페이지 네비게이터 Store
	 * 
	 * @param sqlSession
	 * @param currentPage
	 * @return string
	 */
	public String generatePageNavi(SqlSession sqlSession, int currentPage);

	/**
	 * 공지사항 전체 게시물 갯수 Store
	 * 
	 * @param sqlSession
	 * @return int
	 */
	public int getRecordTotalCount(SqlSession sqlSession);

	/**
	 * 공지사항 상세 조회 Store
	 * 
	 * @param sqlSession
	 * @param num
	 * @return Notice
	 */
	public Notice selectOneNotice(SqlSession sqlSession, int num);

	/**
	 * 공지사항 삭제 Store
	 * 
	 * @param sqlSession
	 * @param num
	 * @return int
	 */
	public int deleteNotice(SqlSession sqlSession, int num);

	/**
	 * 공지사항 수정 Store
	 * 
	 * @param sqlSession
	 * @param notice
	 * @return int
	 */
	public int modifyNotice(SqlSession sqlSession, Notice notice);

}
