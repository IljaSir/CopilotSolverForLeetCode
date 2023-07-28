class Solution {
    public int maximumGap(int[] nums) {
        
        if (nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] maxBucket = new int[nums.length - 1];
        int[] minBucket = new int[nums.length - 1];
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min || nums[i] == max) {
                continue;
            }
            int index = (nums[i] - min) / gap;
            maxBucket[index] = Math.max(maxBucket[index], nums[i]);
            minBucket[index] = Math.min(minBucket[index], nums[i]);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, minBucket[i] - previous);
            previous = maxBucket[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}