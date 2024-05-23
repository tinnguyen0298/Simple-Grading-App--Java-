package finalExam;

public class Node {
	public double numGrade;
	public String strGrade;
	/**
	 * @param numGrade
	 * @param strGrade
	 */
	public Node(double numGrade, String strGrade) {
		super();
		this.numGrade = numGrade;
		this.strGrade = strGrade;
	}
	public double getNumGrade() {
		return numGrade;
	}
	public void setNumGrade(double numGrade) {
		this.numGrade = numGrade;
	}
	public String getStrGrade() {
		return strGrade;
	}
	public void setStrGrade(String strGrade) {
		this.strGrade = strGrade;
	}
	@Override
	public String toString() {
		String result = String.format("%-7.2f %3s", this.numGrade, this.strGrade);
		return result;
	}
	
}
