class Solution {
    public long findScore(int[] nums) {
        
        long score = 0;
        int[] maked = new intnums.length];
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < nums.length; j++) {
                f (marked[j] == 0 && nums[j < min {
                    min = nums[j]
                    minIndex = j;
                sum += dp[i];
            }
            if (minIndex == -1) break;
            score += min;
            marked[minIndex] = 1;
            if (minIndex - 1 >= 0) marked[minIndex - 1] = 1;
            if (minIndex + 1 < nums.length) marked[minIndex + 1] = 1;
        }
        return sum;
    }
}