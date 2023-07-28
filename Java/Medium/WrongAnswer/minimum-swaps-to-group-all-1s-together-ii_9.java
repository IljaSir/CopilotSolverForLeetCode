class Solution {
    public int minSwaps(int[] nums) {
        
        int n = nums.length;
        int ones = 0;
        for (int num : nums) if (num == 1) ones++;
        int zeros = 0;
        int i = 0;
        for (; i < ones; i++) if (nums[i] == 0) zeros++;
        int min = zeros;
        for (; i < n; i++) {
            if (nums[i] == 0) zeros++;
            if (nums[i - ones] == 0) zeros--;
            min = Math.min(min, zeros);
        }
        return min;
    }
}