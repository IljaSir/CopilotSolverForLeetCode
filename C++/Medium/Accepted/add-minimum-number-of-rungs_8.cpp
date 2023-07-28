class Solution {
public:
    int addRungs(vector<int>& rungs, int dist) {
        
        int res = 0;
        int cur = 0;
        for (auto rung : rungs) {
            if (rung - cur > dist) {
                res += (rung - cur) / dist;
                if ((rung - cur) % dist == 0) {
                    res--;
                }
            }
            cur = rung;
        }
        return res;
    }
};