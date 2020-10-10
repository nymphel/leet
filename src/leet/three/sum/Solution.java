package leet.three.sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int nums[] = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> answer = new Solution().threeSum(nums);
        System.out.println(answer);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        HashSet<List<Integer>> threeSum = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        int max = nums[k];
                        if (nums[i] > max || nums[j] > max) {
                            if (nums[i] > nums[j]) {
                                max = nums[i];
                            } else {
                                max = nums[j];
                            }
                        }
                        int min = nums[k];
                        if (nums[i] < min || nums[j] < min) {
                            if (nums[i] < nums[j]) {
                                min = nums[i];
                            } else {
                                min = nums[j];
                            }
                        }
                        int mid = nums[i] + nums[j] + nums[k] - max - min;
                        temp.add(min);
                        temp.add(mid);
                        temp.add(max);

                        //temp.add(nums[i]);
                        //temp.add(nums[j]);
                        //temp.add(nums[k]);
                        //Collections.sort(temp);
                        threeSum.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(threeSum);
    }
}
