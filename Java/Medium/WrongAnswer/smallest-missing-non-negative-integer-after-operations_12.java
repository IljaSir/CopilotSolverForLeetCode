class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0];
        int max = nums[n - 1];
        int maxMex = max - min + 1;
        int maxVal = max + value;
        int minVal = min - value;
        int minMex = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (i > 0 && cur == nums[i - 1]) {
                continue;
            }
            if (cur - minVal > value) {
                minMex = cur - value - minVal;
                break;
            }
            minVal = cur + value;
        }
        if (minMex == 0) {
            if (maxVal - minVal > value) {
                minMex = maxVal - value - minVal;
            }
        }
        return Math.min(maxMex, minMex);
    }
}