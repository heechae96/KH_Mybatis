package member.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;
import member.model.vo.Pagination;

public class MemberStoreImpl implements MemberStore {

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

	@Override
	public List<Member> selectAllMembers(SqlSession session, Pagination pn) {
		List<Member> mList = session.selectList("memberMapper.selectAllMembers", pn);
		return mList;
	}

	@Override
	public String generateNavi(SqlSession session, int currentPage, int recordCntPerPage) {
		int recordTotalCnt = this.getTotalCnt(session);
		int naviTotalCnt;
		if (recordTotalCnt % recordCntPerPage != 0) {
			naviTotalCnt = recordTotalCnt / recordCntPerPage + 1;
		} else {
			naviTotalCnt = recordTotalCnt / recordCntPerPage;
		}
		int naviCntPerPage = 5; // 한번에 노출시킬 네비게이터의 수
		int startNavi = ((currentPage - 1) / naviCntPerPage) * naviCntPerPage + 1;
		int endNavi = startNavi + naviCntPerPage - 1;
		if (endNavi > naviTotalCnt) {
			endNavi = naviTotalCnt;
		}
		StringBuilder sb = new StringBuilder();
		if (!(currentPage == 1)) {
			sb.append("<a href = '/member/list.do?page=" + 1 + "'>처음 </a>");
		}
		if (currentPage != 1) {
			sb.append("<a href = '/member/list.do?page=" + (currentPage - 1) + "'>< </a>");
		}
		for (int i = startNavi; i <= endNavi; i++) {
			if (currentPage == i) {
				sb.append("<a style='color: blue; font-size: large' " 
						+ "href='/member/list.do?page=" + i + "'>" + i
						+ " </a>");
			} else {
				sb.append("<a href='/member/list.do?page=" + i + "'>" + i + " </a>");
			}
		}
		if (currentPage != naviTotalCnt) {
			sb.append("<a href = '/member/list.do?page=" + (currentPage + 1) + "'> ></a>");
		}
		if (!(currentPage == naviTotalCnt)) {
			sb.append("<a href = '/member/list.do?page=" + naviTotalCnt + "'> 끝</a>");
		}
		return sb.toString();
	}

	@Override
	public int getTotalCnt(SqlSession session) {
		int totalcnt = session.selectOne("memberMapper.getTotalCnt");
		return totalcnt;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("memberMapper.deleteMember", memberId);
		return result;
	}

	@Override
	public Member selectOneById(SqlSession session, String memberId) {
		Member meber = session.selectOne("memberMapper.selectOneById", memberId);
		return meber;
	}

	@Override
	public int modifyMember(SqlSession session, Member member) {
		int result = session.update("memberMapper.modifyMember", member);
		return result;
	}

}
