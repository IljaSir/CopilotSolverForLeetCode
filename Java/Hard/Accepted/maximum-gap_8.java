class Solution {
    public int maximumGap(int[] nums) {
        
        if (nums.length < 2) {
            return 0;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int bucketSize = Math.max(1, (max - min) / (nums.length - 1));
        int bucketCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][2];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i][0] = -1;
            buckets[i][1] = -1;
        }
        for (int num: nums) {
            int idx = (num - min) / bucketSize;
            if (buckets[idx][0] == -1) {
                buckets[idx][0] = num;
                buckets[idx][1] = num;
            } else {
                buckets[idx][0] = Math.min(buckets[idx][0], num);
                buckets[idx][1] = Math.max(buckets[idx][1], num);
            }
        }
        int gap = 0;
        int prev = 0;
        for (int i = 1; i < bucketCount; i++) {
            if (buckets[i][0] == -1) {
                continue;
            }
            gap = Math.max(gap, buckets[i][0] - buckets[prev][1]);
            prev = i;
        }
        return gap;
    }
}