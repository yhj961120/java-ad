package kr.or.ddit.borad.vo;

public class BoardVO {
	private String bodNo;
	private String bodTitle;
	private String bodWriter;
	private String bodDate;
	private String bodContent;
	public String getBodNo() {
		return bodNo;
	}
	public void setBodNo(String bodNo) {
		this.bodNo = bodNo;
	}
	public String getBodTitle() {
		return bodTitle;
	}
	public void setBodTitle(String bodTitle) {
		this.bodTitle = bodTitle;
	}
	public String getBodWriter() {
		return bodWriter;
	}
	public void setBodWriter(String bodWriter) {
		this.bodWriter = bodWriter;
	}
	public String getBodDate() {
		return bodDate;
	}
	public void setBodDate(String bodDate) {
		this.bodDate = bodDate;
	}
	public String getBodContent() {
		return bodContent;
	}
	public void setBodContent(String bodContent) {
		this.bodContent = bodContent;
	}
	@Override
	public String toString() {
		return "MemberVO [bodNo=" + bodNo + ", bodTitle=" + bodTitle + ", bodWriter=" + bodWriter + ", bodDate="
				+ bodDate + ", bodContent=" + bodContent + "]";
	}

	
}

