package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.service.NoticeServiceImpl;
import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.model.vo.Pagination;

/**
 * Servlet implementation class NoticeRegistController
 */
@WebServlet("/notice/list.do")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeService nService = new NoticeServiceImpl();

		// 페이징 처리
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		Pagination pagePagination = new Pagination(page, 10);
		PageData pd = nService.printAllNotice(pagePagination);
		List<Notice> nList = pd.getNotiList();
		String pageNavi = pd.getPageNavigator();
		if (!nList.isEmpty()) {
			// 성공
			request.setAttribute("nList", nList);
			request.setAttribute("pageNavi", pageNavi);
			request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
		} else {
			// 실패
			// 데이터가 35개 있고, 한 페이지에 10개씩 보여줄때. 5페이지를 조회 하는 경우
			request.setAttribute("title", "서비스 실패");
			request.setAttribute("msg", "해당 페이지에는 데이터가 없습니다.");
			request.setAttribute("url", "/notice/list.do");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
