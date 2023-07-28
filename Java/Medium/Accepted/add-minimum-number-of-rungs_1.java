class Solution {
    public int addRungs(int[] rungs, int dist) {
        
        int ans = 0;
        int pre = 0;
        for (int rung : rungs) {
            ans += (rung - pre - 1) / dist;
            pre = rung;
        }
        return ans;
    }
}