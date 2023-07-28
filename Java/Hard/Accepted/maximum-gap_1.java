class Solution {
    public int maximumGap(int[] nums) {
        
        if (nums.length < 2) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int bucketSize = Math.max(1, (max - min) / (nums.length - 1));
        int bucketCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][2];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i][0] = -1;
            buckets[i][1] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            int idx = (nums[i] - min) / bucketSize;
            if (buckets[idx][0] == -1) {
                buckets[idx][0] = nums[i];
                buckets[idx][1] = nums[i];
            } else {
                if (nums[i] < buckets[idx][0]) {
                    buckets[idx][0] = nums[i];
                }
                if (nums[i] > buckets[idx][1]) {
                    buckets[idx][1] = nums[i];
                }
            }
        }
        int prev = -1;
        int maxGap = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (buckets[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                maxGap = Math.max(maxGap, buckets[i][0] - buckets[prev][1]);
            }
            prev = i;
        }
        return maxGap;
    }
}