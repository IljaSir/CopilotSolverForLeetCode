class Solution {
    public long countPairs(int[] nums, int k) {
        
        int n = nums.length;
        int[] mod = new int[k];
        for (int i = 0; i < n; i++) {
            mod[nums[i] % k]++;
        }
        long ans = 0;
        if (k % 2 == 0) {
            for (int i = 1; i <= k / 2; i++) {
                if (i == k / 2) {
                    ans += (long) mod[i] * (mod[i] - 1) / 2;
                } else {
                    ans += (long) mod[i] * mod[k - i];
                }
            }
        } else {
            for (int i = 1; i < k; i++) {
                ans += (long) mod[i] * mod[k - i];
            }
        }
        ans += (long) mod[0] * (mod[0] - 1) / 2;
        return ans;
    }
}