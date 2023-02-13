package member.model.service;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.store.MemberStore;
import member.model.store.MemberStoreImpl;
import member.model.vo.Member;

public class MemberServiceImpl implements MemberService{

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

}
