class Solution {
    public int longestSquareStreak(int[] nums) {
        
        int max = 0;
        int count = 0;
        int last = 0;
        for (int num : nums) {
            if (num == last) {
                continue;
            }
            if (num == last * last) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
            last = num;
        }
        return max < 2 ? -1 : max;
    }
}