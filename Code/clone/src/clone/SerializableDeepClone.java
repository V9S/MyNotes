package clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * 通过序列化方式实现深克隆
 * @author ZLM
 *
 */
public class SerializableDeepClone implements Serializable {

	private static final long serialVersionUID = 1L;
	public int a;
	public Integer b ;
	private int c ;
	public SerializableDeepClone o = null;
	public ArrayList<Object> t;
	
	
	public Object serializableDeepClone() throws IOException,ClassNotFoundException{
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos= null;
        oos.writeObject(this);
        oos.flush();
        //将对象从流中取出
        ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois=new ObjectInputStream(bis);
        return (Object)ois.readObject();
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
	public SerializableDeepClone getO() {
		return o;
	}
	public void setO(SerializableDeepClone o) {
		this.o = o;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
