class Solution {
    public int maximumGap(int[] nums) {
        
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // min == max
        if (min == max) {
            return 0;
        }
        int gap = (max - min) / (n - 1);
        if (gap == 0) {
            gap = 1;
        }
        int bucketNum = (max - min) / gap + 1;
        int[] bucketMin = new int[bucketNum];
        int[] bucketMax = new int[bucketNum];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int num : nums) {
            int index = (num - min) / gap;
            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
        }
        int maxGap = 0;
        int prev = min;
        for (int i = 0; i < bucketNum; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        return maxGap;
    }
}