
public class TableRow {
	String symbol;
	int add, index;
	public TableRow(String s, int a, int i) {
		symbol = s;
		add = a;
		index = i;
	}
	
	public String getsymbol() {
		return symbol;
	}
	public void setsymbol(String s) {
		symbol = s;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int i) {
		index = i;
	}
	public void setAddress(int a) {
		add = a;
	}
	public int getAddress() {
		return add;
	}
}
