package algorithms;

/**
 * @author ZLM
 * @date 2019/11/15
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 */
public class Solution_1 {

    public static void main(String[] args) {
        int[] num1 = {1,4,5,9,0,0,0,0,0,0,0,0,0};
        int[] num2 = {2,6,8,87,777};
        for (int i : merge(num1,4,num2,5)) {
            System.out.println(i);
        }
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i =0;i<nums2.length;i++) {
            for(int l=i;n<nums1.length;l++) {
                
            }
        }
        return nums1;
    }

}
