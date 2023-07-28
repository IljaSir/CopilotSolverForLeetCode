class Solution {
    public int addRungs(int[] rungs, int dist) {
        
        int n = rungs.length;
        int ret = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int d = rungs[i] - cur;
            if (d > dist) {
                ret += (d + dist - 1) / dist - 1;
            }
            cur = rungs[i];
        }
        return ret;
    }
}