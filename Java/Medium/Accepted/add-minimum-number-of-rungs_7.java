class Solution {
    public int addRungs(int[] rungs, int dist) {
        
        int n = rungs.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int pre = i == 0 ? 0 : rungs[i - 1];
            int cur = rungs[i];
            int d = cur - pre;
            if (d <= dist) {
                continue;
            }
            if (d % dist == 0) {
                ans += d / dist - 1;
            } else {
                ans += d / dist;
            }
        }
        return ans;
    }
}