class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        
        int sum1 = 0, sum2 = 0;
        for (int num : nums1) sum1 += num;
        for (int num : nums2) sum2 += num;
        if (sum1 == sum2) return 0;
        if (sum1 < sum2) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int tmpSum = sum1;
            sum1 = sum2;
            sum2 = tmpSum;
        }
        int[] diff = new int[6];
        for (int num : nums1) diff[6 - num]++;
        for (int num : nums2) diff[num - 1]++;
        int i = 5, res = 0;
        while (sum1 > sum2) {
            while (diff[i] == 0) i--;
            sum1 -= (6 - i);
            res++;
            diff[i]--;
        }
        return res;
    }
}