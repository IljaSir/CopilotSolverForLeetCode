class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        
        vector<int> ans;
        int n = positions.size();
        int h = 0;
        vector<int> heights(n, 0);
        for (int i = 0; i < n; i++) {
            int l = positions[i][0], r = l + positions[i][1];
            int cur = heights[i] = positions[i][1];
            for (int j = i + 1; j < n; j++) {
                int l1 = positions[j][0], r1 = l1 + positions[j][1];
                if (r > l1 && l < r1) {
                    cur = max(cur, heights[j] + positions[i][1]);
                }
            }
            h = max(h, cur);
            ans.push_back(h);
        }
        return ans;
    }
};