class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        long ans = 0;
        int[] bits = new int[31];
        for (int num : nums) {
            for (int i = 0; i < 31; ++i) {
                if ((num & (1 << i)) != 0) {
                    bits[i]++;
                }
            }
        }
        for (int num : nums) {
            long sum = 0;
            for (int i = 0; i < 31; ++i) {
                if ((num & (1 << i)) != 0) {
                    sum += bits[i];
                } else {
                    sum += nums.length - bits[i];
                }
            }
            if (sum >= k) {
                ans++;
            }
        }
        return ans / 2;
    }
}