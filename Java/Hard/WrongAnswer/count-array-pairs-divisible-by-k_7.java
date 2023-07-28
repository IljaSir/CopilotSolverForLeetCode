class Solution {
    public long countPairs(int[] nums, int k) {
        
        long res = 0;
        int[] cnt = new int[k];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] % k;
            if (n < 0) {
                n += k;
            }
            res += cnt[(k - n) % k];
            cnt[n]++;
        }
        return res;
    }
}