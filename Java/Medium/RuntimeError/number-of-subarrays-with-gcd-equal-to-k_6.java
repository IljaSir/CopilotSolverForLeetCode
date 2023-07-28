class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int[] f = new int[k];
        for (int i = 0; i < nums.length; ++i) {
            f[nums[i] % k]++;
        }
        int ans = 0;
        for (int i = 0; i <= k / 2; ++i) {
            if (i == 0 || k % i == 0) {
                int j = k - i;
                if (i == j) {
                    ans += f[i] > 0 ? 1 : 0;
                } else {
                    ans += f[i] > 0 && f[j] > 0 ? 1 : 0;
                }
            }
        }
        return ans;
    }
}