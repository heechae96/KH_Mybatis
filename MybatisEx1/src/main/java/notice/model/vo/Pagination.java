package notice.model.vo;

// 페이징 처리
public class Pagination {
	private int currentPage; // 현재 페이지
	private int recordCountPerPage; // 페이지당 보여줄 항목의 갯수
	private int start;
	private int end;

	public Pagination() {
	}

	public Pagination(int currentPage, int recordCountPerPage) {
		super();
		this.currentPage = currentPage;
		this.recordCountPerPage = recordCountPerPage;
		this.start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		this.end = currentPage * recordCountPerPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}
	
}
