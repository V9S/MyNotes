package clone;

import java.util.ArrayList;

public class DeepClone implements Cloneable{

	public int a;
	public Integer b ;
	private int c ;
	public DeepClone o ;
	public ArrayList<DeepClone> t;
	
	@Override
	public Object clone() throws CloneNotSupportedException {// 重写Object中的clone()方法
		
		DeepClone deepClone = (DeepClone) super.clone();
		deepClone.setO((DeepClone) deepClone.o.clone());
		deepClone.setT((ArrayList<DeepClone>) deepClone.getT().clone());
		return deepClone;
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



	public DeepClone getO() {
		return o;
	}



	public void setO(DeepClone o) {
		this.o = o;
	}



	public ArrayList<DeepClone> getT() {
		return t;
	}



	public void setT(ArrayList<DeepClone> t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "DeepClone [a=" + a + ", b=" + b + ", c=" + c + ", o=" + o + ", t=" + t + "]";
	}



	
}
