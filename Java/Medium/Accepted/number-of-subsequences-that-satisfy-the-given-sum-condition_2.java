class Solution {
    public int numSubseq(int[] nums, int target) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; ++i) {
            pow[i] = pow[i - 1] * 2 % 1000000007;
        }
        int ans = 0;
        for (int i = 0, j = n - 1; i <= j; ++i) {
            while (i <= j && nums[i] + nums[j] > target) --j;
            if (i <= j) ans = (ans + pow[j - i]) % 1000000007;
        }
        return ans;
    }
}