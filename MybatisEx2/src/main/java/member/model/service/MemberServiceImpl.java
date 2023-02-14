package member.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.store.MemberStore;
import member.model.store.MemberStoreImpl;
import member.model.vo.Member;
import member.model.vo.PageData;
import member.model.vo.Pagination;

public class MemberServiceImpl implements MemberService {

	private MemberStore mStore;

	public MemberServiceImpl() {
		mStore = new MemberStoreImpl();
	}

	@Override
	public Member checkMemberLogin(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mStore.checkMemberLogin(session, member);
		return mOne;
	}

	@Override
	public int registerMember(Member mOne) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mStore.insertMember(session, mOne);
		session.commit();
		// session.close()는 트랜잭션 처리 할 때만!
		session.close();
		return result;
	}

	@Override
	public PageData selectAllMembers(int currentPage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int recordCountPerPage = 10;
		int start = recordCountPerPage * currentPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		Pagination pn = new Pagination(start, end);
		List<Member> mList = mStore.selectAllMembers(session, pn);
		String navigator = mStore.generateNavi(session, currentPage);
		PageData pd = new PageData(mList, navigator);
		return pd;
	}

	@Override
	public int deleteMember(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mStore.deleteMember(session, memberId);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Member selectOneById(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mStore.selectOneById(session, memberId);
		return mOne;
	}

	@Override
	public int modifyMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mStore.modifyMember(session, member);
		session.commit();
		session.close();
		return result;
	}

}
