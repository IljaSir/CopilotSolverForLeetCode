class Solution {
public:
    int addRungs(vector<int>& rungs, int dist) {
        
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < rungs.size(); ++i) {
            if (rungs[i] - cur > dist) {
                ans += (rungs[i] - cur - 1) / dist;
            }
            cur = rungs[i];
        }
        return ans;
    }
};