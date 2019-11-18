 package recursion;

 /**
 * @author ZLM
 * @date 2019/11/18
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class FROG {
    public static void main(String[] args) {
        System.out.println(fun(3));
    }
    /**
     * 
     * @param n 代表第n级台阶
     * @return  代表多少种跳法
     */
    public static int fun(int n) {
        if(n<=2) {
            return n;
        }
        return fun(n-1)+fun(n-2);
    }
}
