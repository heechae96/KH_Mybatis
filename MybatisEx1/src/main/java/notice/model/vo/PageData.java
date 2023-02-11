package notice.model.vo;

import java.util.List;

public class PageData {
	private List<Notice> notiList;
	private String pageNavigator;
	
	public PageData() {
		super();
	}

	public PageData(List<Notice> notiList, String pageNavigator) {
		super();
		this.notiList = notiList;
		this.pageNavigator = pageNavigator;
	}
	
	public List<Notice> getNotiList() {
		return notiList;
	}
	public void setNotiList(List<Notice> notiList) {
		this.notiList = notiList;
	}
	public String getPageNavigator() {
		return pageNavigator;
	}
	public void setPageNavigator(String pageNavigator) {
		this.pageNavigator = pageNavigator;
	}
	
}
