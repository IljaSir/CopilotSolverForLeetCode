class Solution {
    public int numSubseq(int[] nums, int target) {
        
        Arrays.sort(nums);
        int mod = 1000000007;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = pow[i - 1] * 2 % mod;
        }
        int res = 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                res = (res + pow[r - l]) % mod;
                l++;
            }
        }
        return res;
    }
}