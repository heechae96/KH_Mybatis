package member.model.store;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;

public interface MemberStore {
	
	/**
	 * 멤버 로그인 Store
	 * @param session
	 * @param member
	 * @return Member
	 */
	public Member checkMemberLogin(SqlSession session, Member member);

	/**
	 * 멤버 등록 Store
	 * @param session
	 * @param member
	 * @return int
	 */
	public int insertMember(SqlSession session, Member member);
}
