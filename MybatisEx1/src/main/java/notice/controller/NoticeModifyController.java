package notice.controller;

import notice.model.service.NoticeService;
import notice.model.service.NoticeServiceImpl;
import notice.model.vo.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class NoticeModifyController
 */
@WebServlet("/notice/modify.do")
public class NoticeModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeModifyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String noticeNum = request.getParameter("notice-no") != null ? request.getParameter("notice-no") : "0";
		int num = Integer.parseInt(noticeNum);
		NoticeService nService = new NoticeServiceImpl();
		Notice notice = nService.printNoticeByNo(num);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String num = request.getParameter("notice-no") != null ? request.getParameter("notice-no") : "0";
		int noticeNo = Integer.parseInt(num);
		Notice notice = new Notice(noticeNo, subject, content, "admin");
		NoticeService nService = new NoticeServiceImpl();
		int result = nService.modifyNotice(notice);
		String goDetail = "/notice/detail.do?notice-no=" + num;
		if (result > 0) {
			response.sendRedirect(goDetail);
		} else {
			request.setAttribute("title", "서비스 실패");
			request.setAttribute("msg", "공지사항 수정 실패");
			request.setAttribute("url", "/notice/detail.do?notice-no=" + num);
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
