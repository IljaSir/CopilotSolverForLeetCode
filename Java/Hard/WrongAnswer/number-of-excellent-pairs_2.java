class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        int[] cnt = new int[60];
        for (int n : nums) {
            for (int i = 0; i < 60; i++) {
                if ((n & (1 << i)) > 0) {
                    cnt[i]++;
                }
            }
        }
        long ans = 0;
        for (int n : nums) {
            long sum = 0;
            for (int i = 0; i < 60; i++) {
                if ((n & (1 << i)) > 0) {
                    sum += cnt[i];
                } else {
                    sum += nums.length - cnt[i];
                }
            }
            if (sum >= k) {
                ans++;
            }
        }
        return ans;
    }
}