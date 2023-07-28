class Solution {
    public int numOfWays(int[] nums) {
        
        int n = nums.length;
        int MOD = 1000000007;
        return (int) (dfs(nums) - 1) % MOD;
    }
    
    private long dfs(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }
        
        int n = nums.length;
        int root = nums[0];
        int left = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < root) {
                ++left;
            }
        }
        
        int right = n - 1 - left;
        int[] numsLeft = new int[left];
        int[] numsRight = new int[right];
        int l = 0;
        int r = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < root) {
                numsLeft[l++] = nums[i];
            } else {
                numsRight[r++] = nums[i];
            }
        }
        
        long c1 = dfs(numsLeft);
        long c2 = dfs(numsRight);
        long c3 = c1 * c2;
        long c4 = c3 * comb(left + right, left);
        return c4;
    }
    
    private long comb(int n, int k) {
        long res = 1;
        for (int i = 1; i <= k; ++i) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }
}