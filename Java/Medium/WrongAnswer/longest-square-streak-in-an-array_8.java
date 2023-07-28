class Solution {
    public int longestSquareStreak(int[] nums) {
        
        int longest = 0;
        int current = 0;
        int previous = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (i == 0) {
                previous = num;
                current = 1;
            } else if (num == previous * previous) {
                current++;
            } else {
                longest = Math.max(longest, current);
                current = 1;
            }
            previous = num;
        }
        longest = Math.max(longest, current);
        return longest >= 2 ? longest : -1;
    }
}