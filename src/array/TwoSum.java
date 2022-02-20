package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanlix
 * @date 2022/2/20
 */

/*
1. Two Sum
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {150,24,79,50,88,345,3};
        int[] res = twoSumV2(nums,200);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            System.out.print(" ");
        }
    }

    // HashMap
    // 边存边算，算出结果立即返回。
    public static int[] twoSum(int[] nums, int target) {
        //Map<value,index>
        Map<Integer, Integer> map = new HashMap<>();
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                index[0] = map.get(target-nums[i]);
                index[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return index;
    }

    //二分法
    //在一个新的数组中，对数组进行排序。利用二分法，找出两个value；
    //再遍历原数组，找出value对应的index。
    public static int[] twoSumV2(int[] nums, int target) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        //二分法的前提要数组有序
        Arrays.sort(newNums);
        //注意使用的是索引，方便循环
        int left = 0;
        int right = newNums.length-1;
        int a = 0, b = 0;

        while (left < right) {
            if (newNums[left] + newNums[right] == target) {
                a = newNums[left];
                b = newNums[right];
                break;
            }
            else if (newNums[left] + newNums[right] < target) {
                left++;
            }
            else {
                right--;
            }
        }

        int[] res = new int[2];
        // 为避免两个相同的值取同样的index，分别往相反方向遍历
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a || nums[i] == b) {
                res[0]= i;
                break;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == target - nums[res[0]]) {
                res[1]= i;
                break;
            }
        }
        return res;
    }
}


