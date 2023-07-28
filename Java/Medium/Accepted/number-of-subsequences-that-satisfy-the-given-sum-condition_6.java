class Solution {
    public int numSubseq(int[] nums, int target) {
        
        int mod = (int)1e9 + 7;
        int n = nums.length;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        Arrays.sort(nums);
        int res = 0;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else {
                res = (res + pow[j - i]) % mod;
                i++;
            }
        }
        return res;
    }
}