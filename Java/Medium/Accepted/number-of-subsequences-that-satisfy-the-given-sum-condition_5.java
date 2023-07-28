class Solution {
    public int numSubseq(int[] nums, int target) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0, mod = (int)1e9 + 7;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; ++i) {
            pow[i] = pow[i - 1] * 2 % mod;
        }
        for (int i = 0, j = n - 1; i <= j;) {
            if (nums[i] + nums[j] > target) {
                --j;
            } else {
                res = (res + pow[j - i]) % mod;
                ++i;
            }
        }
        return res;
    }
}