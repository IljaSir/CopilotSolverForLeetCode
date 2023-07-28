class Solution {
public:
    int addRungs(vector<int>& rungs, int dist) {
        
        int res = 0;
        int cur = 0;
        for (int i = 0; i < rungs.size(); ++i) {
            int d = rungs[i] - cur;
            res += (d - 1) / dist;
            cur = rungs[i];
        }
        return res;
    }
};