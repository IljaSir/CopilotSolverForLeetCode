class Solution {
    public int addRungs(int[] rungs, int dist) {
        
        int n = rungs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = rungs[i];
            if (i > 0) {
                cur -= rungs[i - 1];
            }
            ans += (cur - 1) / dist;
        }
        return ans;
    }
}