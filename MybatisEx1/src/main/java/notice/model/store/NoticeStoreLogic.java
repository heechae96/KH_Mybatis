package notice.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;
import notice.model.vo.Pagination;

public class NoticeStoreLogic implements NoticeStore {

	@Override
	public int insertNotice(SqlSession sqlSession, Notice notice) {
		int result = sqlSession.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public List<Notice> selectAllNotice(SqlSession sqlSession, Pagination pageNation) {
		List<Notice> nList = sqlSession.selectList("NoticeMapper.selectAllNotice", pageNation);
		return nList;
	}

	@Override
	public String generatePageNavi(SqlSession sqlSession, int currentPage) {
		int totalCnt = getRecordTotalCount(sqlSession); // 전체 게시물의 갯수
		int recordCountPerPage = 10; // 한 페이지 당 보여줄 게시물의 갯수
		int naviTotalCnt = 0; // 네비게이터 전체 페이지 수 ex) 62/10 -> 7

		if (totalCnt % recordCountPerPage > 0) {
			naviTotalCnt = totalCnt / recordCountPerPage + 1;
		} else {
			naviTotalCnt = totalCnt / recordCountPerPage;
		}

		int naviCntPerPage = 10; // 한 페이지 당 보여줄 네비게이터의 수
		int startNavi = ((currentPage - 1) / naviCntPerPage) * naviCntPerPage + 1;
		int endNavi = startNavi + naviCntPerPage - 1;

		if (endNavi > naviTotalCnt) {
			endNavi = naviTotalCnt; // 최대값으로 다시 셋팅
		}

		StringBuilder sb = new StringBuilder();
		for (int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href = '/notice/list.do?page=" + i + "'> " + i + " </a>");
		}
		return sb.toString();
	}

	@Override
	public int getRecordTotalCount(SqlSession sqlSession) {
		int result = sqlSession.selectOne("NoticeMapper.selectTotalCnt");
		return result;
	}

	@Override
	public Notice selectOneNotice(SqlSession sqlSession, int num) {
		Notice notice = sqlSession.selectOne("NoticeMapper.selectOneNotice", num);
		return notice;
	}

	@Override
	public int deleteNotice(SqlSession sqlSession, int num) {
		int result = sqlSession.delete("NoticeMapper.deleteOneNotice", num);
		return result;
	}

	@Override
	public int modifyNotice(SqlSession sqlSession, Notice notice) {
		int result = sqlSession.delete("NoticeMapper.updateNotice", notice);
		return result;
	}

}
