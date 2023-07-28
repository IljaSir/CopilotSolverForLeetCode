class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        
        int sum1 = 0, sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }
        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 < sum2) {
            return minOperations(nums2, nums1);
        }
        int[] count1 = new int[7];
        int[] count2 = new int[7];
        for (int num : nums1) {
            count1[num]++;
        }
        for (int num : nums2) {
            count2[num]++;
        }
        int diff = sum1 - sum2;
        int res = 0;
        for (int i = 6; i >= 1; i--) {
            int take = Math.min(count1[i] - 1, (diff + i - 1) / i);
            diff -= take * i;
            res += take;
            if (diff == 0) {
                return res;
            }
        }
        return -1;
    }
}