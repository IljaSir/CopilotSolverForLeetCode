class Solution {
public:
    int addRungs(vector<int>& rungs, int dist) {
        
        int ans = 0;
        int pre = 0;
        for (int i = 0; i < rungs.size(); i++) {
            int diff = rungs[i] - pre;
            if (diff > dist) {
                ans += (diff - 1) / dist;
            }
            pre = rungs[i];
        }
        return ans;
    }
};