class Solution {
    public int maximumGap(int[] nums) {
        
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int gap = (int) Math.ceil((double) (max - min) / (n - 1));
        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            if (nums[i] == max || nums[i] == min) {
                continue;
            }
            int idx = (nums[i] - min) / gap;
            bucketMin[idx] = Math.min(bucketMin[idx], nums[i]);
            bucketMax[idx] = Math.max(bucketMax[idx], nums[i]);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < n - 1; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - previous);
            previous = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}