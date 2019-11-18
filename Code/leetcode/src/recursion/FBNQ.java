package recursion;

/**
 * @author ZLM
 * @date 2019/11/18 斐波那契数列递归实现f(n)=f(n-1)+f(n-2);1、1、2、3、5、8
 */
public class FBNQ {
    public static void main(String[] args) {
        System.out.println(fun(6));
    }

    /**
     * 
     * @param n 代表的n个数
     * @return  第n个数的值
     */
    public static int fun(int n) {
        if (n <= 2) {
            return 1;
        }
        return fun(n-1)+fun(n-2);
    }
}
