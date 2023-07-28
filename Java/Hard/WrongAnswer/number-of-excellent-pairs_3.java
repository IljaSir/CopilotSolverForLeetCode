class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        long[] count = new long[60];
        for (int n : nums) {
            for (int i = 0; i < 60; i++) {
                if ((n & (1L << i)) != 0) {
                    count[i]++;
                }
            }
        }
        long ans = 0;
        for (int n : nums) {
            long sum = 0;
            for (int i = 0; i < 60; i++) {
                if ((n & (1L << i)) != 0) {
                    sum += (1L << i) * count[i];
                } else {
                    sum += (1L << i) * (nums.length - count[i]);
                }
            }
            if (sum >= k) {
                ans++;
            }
        }
        return ans;
    }
}