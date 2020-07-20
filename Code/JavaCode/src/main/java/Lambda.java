package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lambda {

    private static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        list.add("1");
        list.add("5");
        list.add("giao");
        list.add("55");
        list.add("45");
        list.add("4");
        list.add("0");
        /*  Collections.sort(list, new Comparator<String>() {
        
            @Override
            public int compare(String o1, String o2) {
                return (o2).compareTo(o1);
            }
        
        });*/
        // Collections.sort(list);

        Collections.sort(list, (a, b) -> b.compareTo(a));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator:" + iterator.next());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("for:" + list.get(i));
        }
        for (String string : list) {
            System.out.println("foreach:" + string);
        }
        list.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {
                 System.out.println("list.forEach:"+t);
            }
        });
        System.out.println(list);
    }

}
