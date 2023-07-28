class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Integer, Integer>();
            for (int j = 0; j < i; ++j) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int d = (int) diff;
                int cnt1 = f[j].getOrDefault(d, 0);
                int cnt2 = f[i].getOrDefault(d, 0);
                ans += cnt1;
                f[i].put(d, cnt1 + cnt2 + 1);
            }
        }
        return ans;
    }
}