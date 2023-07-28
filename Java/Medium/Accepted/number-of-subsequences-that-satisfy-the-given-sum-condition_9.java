class Solution {
    public int numSubseq(int[] nums, int target) {
        
        int mod = 1000000007;
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = pow[i - 1] * 2 % mod;
        }
        
        int l = 0;
        int r = n - 1;
        int res = 0;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                res = (res + pow[r - l]) % mod;
                l++;
            } else {
                r--;
            }
        }
        
        return res;
    }
}