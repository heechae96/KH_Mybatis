package member.model.store;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;

public class MemberStoreImpl implements MemberStore{

	@Override
	public Member checkMemberLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("memberMapper.checkMemberLogin", member);
		return mOne;
	}

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("memberMapper.insertMember", member);
		return result;
	}

}
