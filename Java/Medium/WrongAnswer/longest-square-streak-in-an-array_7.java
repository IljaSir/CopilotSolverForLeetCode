class Solution {
    public int longestSquareStreak(int[] nums) {
        
        int n = nums.length;
        if (n < 2)
            return -1;
        int max = 0;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j] * nums[j] && f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                    max = Math.max(max, f[i]);
                }
            }
        }
        return max < 2 ? -1 : max;
    }
}