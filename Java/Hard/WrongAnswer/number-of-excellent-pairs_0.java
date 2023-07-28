class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        long[] bits = new long[60];
        for (int num : nums) {
            for (int i = 0; i < 60; i++) {
                bits[i] += (num >> i) & 1;
            }
        }
        long[] or = new long[60];
        long[] and = new long[60];
        for (int i = 0; i < 60; i++) {
            or[i] = bits[i] * (nums.length - bits[i]);
            and[i] = bits[i] * bits[i];
        }
        long ans = 0;
        for (int i = 0; i < 60; i++) {
            if (or[i] + and[i] >= k) {
                ans += (1L << i);
            }
        }
        return ans;
    }
}