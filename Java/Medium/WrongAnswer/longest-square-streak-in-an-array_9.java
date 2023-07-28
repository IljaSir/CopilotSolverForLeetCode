class Solution {
    public int longestSquareStreak(int[] nums) {
        
        int n = nums.length;
        if(n < 2) return -1;
        int max = 0;
        int prev = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            if(prev == 0) {
                prev = curr;
                count = 1;
            } else if(prev * prev == curr) {
                count++;
                max = Math.max(max, count);
            } else {
                prev = curr;
                count = 1;
            }
        }
        return max;
    }
}