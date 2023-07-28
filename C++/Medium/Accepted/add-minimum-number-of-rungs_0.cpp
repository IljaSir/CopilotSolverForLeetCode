class Solution {
public:
    int addRungs(vector<int>& rungs, int dist) {
        
        int ans = 0;
        int cur = 0;
        for (int rung : rungs) {
            ans += (rung - cur - 1) / dist;
            cur = rung;
        }
        return ans;
    }
};