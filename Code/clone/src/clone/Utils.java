package clone;

import java.util.ArrayList;

public class Utils {

	public static void main(String[] args) {
//		ShallowClone origin = new ShallowClone();
//		DeepClone origin = new DeepClone();
		SerializableDeepClone origin = new SerializableDeepClone();
		Object n = new Object();
		ArrayList<Object> t = new ArrayList<>();
		origin.setA(1);
		origin.setB(2);
		origin.setC(3);

		origin.setT(t);

//		ShallowClone cloneElement = null;
//		DeepClone cloneElement = null;
		SerializableDeepClone cloneElement=null;
		try {
			cloneElement = (SerializableDeepClone) origin.serializableDeepClone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(origin.toString());
		System.out.println(origin.toString());

		System.out.println(origin.o.equals(cloneElement.o));
		System.out.println(origin.t.equals(cloneElement.t));
	}
}
