package leet;

import java.util.Arrays;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return true;
        }
        return tailToHeadCheck(Arrays.copyOf(nums, len), len) || headToTailCheck(nums, len);
    }

    public boolean tailToHeadCheck(int[] nums, int len) {
        int i = len - 2;
        int j = len - 1;
        int decreasingCount = 0;
        while (i >= 0 && decreasingCount < 2) {
            if (nums[i] > nums[j]) {
                decreasingCount++;
                nums[i] = nums[j];
            }
            i--;
            j--;
        }
        return decreasingCount < 2;
    }

    public boolean headToTailCheck(int[] nums, int len) {
        int i = 0;
        int j = 1;
        int decreasingCount = 0;
        while (j < len && decreasingCount < 2) {
            if (nums[i] > nums[j]) {
                decreasingCount++;
                nums[j] = nums[i];
            }
            i++;
            j++;
        }
        return decreasingCount < 2;
    }

    public static void main(String[] args) {
        NonDecreasingArray obj = new NonDecreasingArray();
        System.out.println(obj.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(obj.checkPossibility(new int[]{2, 3, 3, 2, 4}));
        System.out.println(obj.checkPossibility(new int[]{3, 4, 2, 3}));
    }

}
