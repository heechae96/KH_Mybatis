package member.model.service;

import member.model.vo.Member;

public interface MemberService {

	/**
	 * 멤버 로그인 Service
	 * @param member
	 * @return Member
	 */
	public Member checkMemberLogin(Member member);
	
	/**
	 * 멤버 회원가입 Service
	 * @param mOne
	 * @return int
	 */
	public int registerMember(Member mOne);

}
