class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int n = nums.length;
        if (n < 3) return 0;
        int ans = 0;
        Map<Integer, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Integer, Integer>();
            for (int j = 0; j < i; ++j) {
                long diff = (long)nums[i] - nums[j];
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
                int d = (int)diff;
                int cnt1 = f[j].getOrDefault(d, 0);
                int cnt2 = f[i].getOrDefault(d, 0);
                f[i].put(d, cnt2 + cnt1 + 1);
                ans += cnt1;
            }
        }
        return ans;
    }
}