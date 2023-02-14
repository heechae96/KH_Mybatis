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
 * Servlet implementation class MemberModifyController
 */
@WebServlet("/member/modify.do")
public class MemberModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberModifyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			MemberService mService = new MemberServiceImpl();
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("member"); // Object -> Member
			String memberId = member.getMemberId();
			Member mOne = mService.selectOneById(memberId);
			if (mOne != null) {
				request.setAttribute("mOne", mOne);
				request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "해당 정보가 존재하지 않습니다");
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			String memberId = request.getParameter("member-id");
			String memberPw = request.getParameter("member-pw");
			String memberEmail = request.getParameter("member-email");
			String memberPhone = request.getParameter("member-phone");
			String memberAddr = request.getParameter("member-addr");
			String memberHobby = request.getParameter("member-hobby");

			Member member = new Member(memberId, memberPw, memberEmail, memberPhone, memberAddr, memberHobby);
			MemberService mService = new MemberServiceImpl();
			int result = mService.modifyMember(member);
			if (result > 0) {
				response.sendRedirect("/member/modify.do");
			} else {
				request.setAttribute("msg", "정보수정이 완료되지 않았습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
