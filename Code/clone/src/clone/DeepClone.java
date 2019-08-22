package clone;

import java.util.ArrayList;

public class DeepClone implements Cloneable{

	public int a;
	public Integer b ;
	private int c ;
	public Object o;
	public ArrayList<Object> t;
	
	@Override
	public Object clone() throws CloneNotSupportedException {// 重写Object中的clone()方法
		
		DeepClone deepClone = (DeepClone) super.clone();
//		deepClone.setO((DeepClone)deepClone.getO().clone());
		deepClone.setT((ArrayList<Object>) deepClone.getT().clone());
		return deepClone;
	}
	
	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public Integer getB() {
		return b;
	}
	public void setB(Integer b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public ArrayList<Object> getT() {
		return t;
	}
	public void setT(ArrayList<Object> t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "Utils [a=" + a + ", b=" + b + ", c=" + c + ", o=" + o + ", t=" + t + "]";
	}
	
}
