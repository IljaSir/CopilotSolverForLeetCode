class Solution {
    public int maximumGap(int[] nums) {
        
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int minVal = nums[0];
        int maxVal = nums[0];
        for (int i = 1; i < n; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        int d = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketSize = (maxVal - minVal) / d + 1;
        int[] bucketMin = new int[bucketSize];
        int[] bucketMax = new int[bucketSize];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - minVal) / d;
            bucketMin[idx] = Math.min(bucketMin[idx], nums[i]);
            bucketMax[idx] = Math.max(bucketMax[idx], nums[i]);
        }
        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucketMin[i] - bucketMax[prev]);
            }
            prev = i;
        }
        return ret;
    }
}