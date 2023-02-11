package notice.model.service;

import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.model.vo.Pagination;

public interface NoticeService {
	/**
	 * 공지사항 등록 Service
	 * 
	 * @param notice
	 * @return int
	 */
	public int insertNotice(Notice notice);

	/**
	 * 공지사항 목록 등록 Service
	 * 
	 * @return PageData
	 */
	// 기존의 반환 타입은 List<Notice>
	public PageData printAllNotice(Pagination pagination);

	/**
	 * 공지사항 상세조회 Service
	 * 
	 * @param num
	 * @return Notice
	 */
	public Notice printNoticeByNo(int num);

	/**
	 * 공지사항 삭제 Service
	 * 
	 * @param num
	 * @return int
	 */
	public int removeNoticeByNo(int num);

	/**
	 * 공지사항 수정 Service
	 * 
	 * @param notice
	 * @return int
	 */
	public int modifyNotice(Notice notice);
}
