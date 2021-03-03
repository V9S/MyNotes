import java.util.ArrayList;

public class GcTest {

    /**
     * @param args
     * -Xms60m -Xmx60m -XX:SurvivorRatio=8
     */
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<byte[]>();
        for (int i = 1; i < 1000; i++) {
            byte[] arr = new byte[1024 * 100];// 100kB
            try {
                list.add(arr);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
