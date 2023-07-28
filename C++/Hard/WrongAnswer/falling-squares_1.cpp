class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        
        int n = positions.size();
        vector<int> ans(n, 0);
        vector<pair<int, int>> segments;
        for (int i = 0; i < n; ++i) {
            int left = positions[i][0];
            int right = positions[i][0] + positions[i][1] - 1;
            int height = positions[i][1];
            for (auto& seg : segments) {
                if (seg.first <= left && right <= seg.second) {
                    height = max(height, seg.second - seg.first + 1);
                }
            }
            segments.push_back({left, left + height - 1});
            ans[i] = max(ans[i], height);
            for (int j = i + 1; j < n; ++j) {
                ans[j] = max(ans[j], ans[j - 1]);
            }
        }
        return ans;
    }
};