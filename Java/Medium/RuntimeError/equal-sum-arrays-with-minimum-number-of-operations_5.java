class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        
        int sum1 = 0, sum2 = 0;
        for (int n : nums1) sum1 += n;
        for (int n : nums2) sum2 += n;
        if (sum1 == sum2) return 0;
        if (sum1 < sum2) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int t = sum1;
            sum1 = sum2;
            sum2 = t;
        }
        int[] diff = new int[5];
        for (int n : nums1) diff[6 - n]++;
        for (int n : nums2) diff[n - 1]++;
        int i = 4, res = 0;
        while (sum1 > sum2) {
            while (i >= 0 && diff[i] == 0) i--;
            if (i < 0) return -1;
            sum1 -= i + 1;
            diff[i]--;
            res++;
        }
        return res;
    }
}