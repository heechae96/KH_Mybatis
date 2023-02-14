package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.service.MemberServiceImpl;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/member/delete.do")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberDeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인한 사람이 본인의 아이디만 삭제 할수 있도록
		HttpSession session = request.getSession();
		MemberService mService = new MemberServiceImpl();
		try {
			Member member = (Member) session.getAttribute("member");
			String memberId = member.getMemberId();
			int result = mService.deleteMember(memberId);
			if(result > 0) {
				// 로그아웃해서 세션 반환시키도록
				response.sendRedirect("/member/logout.do");
			}else {
				request.setAttribute("msg", "회원 탈퇴가 완료되지 않았습니다");
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
		
	}

}
