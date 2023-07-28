class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        
        vector<int> ans;
        map<int, int> m;
        int cur = 0;
        for (auto& p : positions) {
            int left = p[0], side = p[1], right = left + side;
            auto it = m.lower_bound(left);
            int h1 = (it == m.begin()) ? 0 : prev(it)->second;
            int h2 = (it == m.end()) ? 0 : it->second;
            int h = max(h1, h2);
            m[left] = h + side;
            m[right] = h2;
            cur = max(cur, h + side);
            ans.push_back(cur);
        }
        return ans;
    }
};