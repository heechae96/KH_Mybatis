package notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import notice.model.store.NoticeStore;
import notice.model.store.NoticeStoreLogic;
import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.model.vo.Pagination;

public class NoticeServiceImpl implements NoticeService {

	private NoticeStore nStore;

	public NoticeServiceImpl() {
		nStore = new NoticeStoreLogic();
	}

	@Override
	public int insertNotice(Notice notice) {
		// 1. 연결 생성 -> Store 전달
		// 2. 커밋/롤백
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = nStore.insertNotice(sqlSession, notice);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public PageData printAllNotice(Pagination pagination) {	// 기존의 반환 타입은 List<Notice>
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		List<Notice> nList = nStore.selectAllNotice(sqlSession, pagination);
		String pageNavigator = nStore.generatePageNavi(sqlSession, pagination.getCurrentPage());
		PageData pageData = new PageData(nList, pageNavigator);
		sqlSession.close();
		return pageData;
	}

	@Override
	public Notice printNoticeByNo(int num) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		Notice notice = nStore.selectOneNotice(sqlSession, num);
		sqlSession.close();
		return notice;
	}

	@Override
	public int removeNoticeByNo(int num) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = nStore.deleteNotice(sqlSession, num);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int modifyNotice(Notice notice) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = nStore.modifyNotice(sqlSession, notice);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
