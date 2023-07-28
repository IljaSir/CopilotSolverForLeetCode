class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[n - 1] = 1;
        g[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            f[i] = 1;
            g[i] = 1;
            if (2 * nums[i] <= nums[n - 1]) {
                f[i] = g[n - 1] + 1;
            }
            if (i + 1 < n && 2 * nums[i] <= nums[i + 1]) {
                f[i] = Math.max(f[i], g[i + 1] + 1);
            }
            g[i] = Math.max(g[i], f[i]);
            if (i + 1 < n) {
                g[i] = Math.max(g[i], g[i + 1]);
            }
        }
        return f[0] - 1;
    }
}