class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        
        vector<int> ans;
        int cur = 0;
        for (auto& pos : positions) {
            int left = pos[0], size = pos[1], right = left + size;
            int h = 0;
            for (auto& p : positions) {
                int l = p[0], s = p[1], r = l + s;
                if (l < right && r > left) {
                    h = max(h, p[2]);
                }
            }
            pos.push_back(h + size);
            cur = max(cur, h + size);
            ans.push_back(cur);
        }
        return ans;
    }
};