class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Long, Integer>();
            for (int j = 0; j < i; ++j) {
                long d = (long)nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }
}