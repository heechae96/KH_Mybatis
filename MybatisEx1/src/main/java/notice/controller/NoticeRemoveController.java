package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.service.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeRemoveController
 */
@WebServlet("/notice/remove.do")
public class NoticeRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeRemoveController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String noticeNum = request.getParameter("notice-no") != null ? request.getParameter("notice-no") : "0";
		int num = Integer.parseInt(noticeNum);
		NoticeService nService = new NoticeServiceImpl();
		int result = nService.removeNoticeByNo(num);
		if (result > 0) {
			// System.out.println("삭제 성공");
			// request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
			response.sendRedirect("/notice/list.do");
		} else {
			System.out.println("삭제 실패");
			request.setAttribute("title", "서비스 실패");
			request.setAttribute("msg", "데이터 없음");
			request.setAttribute("url", "/notice/detail.do?notice-no=" + num);
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
