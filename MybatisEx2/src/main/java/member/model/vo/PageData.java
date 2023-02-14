package member.model.vo;

import java.util.List;

public class PageData {
	private List<Member> memberList;
	private String pageNavigator;
	
	public PageData() {
		super();
	}

	public PageData(List<Member> memberList, String pageNavigator) {
		super();
		this.memberList = memberList;
		this.pageNavigator = pageNavigator;
	}
	
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	public String getPageNavigator() {
		return pageNavigator;
	}
	public void setPageNavigator(String pageNavigator) {
		this.pageNavigator = pageNavigator;
	}
	
}
