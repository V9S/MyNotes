 package algorithms;
/**
 * @author ZLM
 * @date 2019/10/18
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution {
       
     public int removeDuplicates(int[] nums) {
//         int temp = nums[0];
//         int len = 0;
//         for(int i=1;i<nums.length;i++) {
//             if(nums[i] == temp) {
//                if(nums.length != i) {
//                nums[i] = nums[i+1];
//                i=i-1;
//                len = i;
//                }
//             }
//             temp = nums[i];
//         }
//         return 0;
//     }
         // 使用双指针
         if(nums==null || nums.length == 1){
             return nums.length;
         }
         int i = 0,j =1;
         while(j<nums.length){
             if(nums[i]==nums[j]){
                 j++;
             }else{
                 i++;
                 nums[i]=nums[j];
                 j++;
             }
         }
         return i+1;
     }

}
