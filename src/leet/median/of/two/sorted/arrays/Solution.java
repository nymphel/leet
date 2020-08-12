package leet.median.of.two.sorted.arrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0d;

        int[] numSum = new int[nums1.length + nums2.length];

        int num1x = 0;
        int num2x = 0;
        int numSx = 0;

        while(num1x < nums1.length && num2x < nums2.length) {
            if(nums1[num1x] < nums2[num2x]) {
                numSum[numSx] = nums1[num1x];
                num1x++;
                numSx++;
            } else {
                numSum[numSx] = nums2[num2x];
                num2x++;
                numSx++;
            }
        }

        while(num1x < nums1.length) {
            numSum[numSx] = nums1[num1x];
            num1x++;
            numSx++;
        }

        while(num2x < nums2.length) {
            numSum[numSx] = nums2[num2x];
            num2x++;
            numSx++;
        }

        int medianIdx = numSum.length / 2;
        if(numSum.length %2 == 0) {
            median = ((double)numSum[medianIdx -1] + (double)numSum[medianIdx]) /2;
        } else {
            median = numSum[medianIdx];
        }

        return median;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int nums1[] = new int[]{1,3};
        int nums2[] = new int[]{2};
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);

        int nums3[] = new int[]{1,2};
        int nums4[] = new int[]{3,4};
        double medianSortedArrays2 = solution.findMedianSortedArrays(nums3, nums4);
        System.out.println(medianSortedArrays2);
    }
}
