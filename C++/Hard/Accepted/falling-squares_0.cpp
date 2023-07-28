class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        
        int n = positions.size();
        vector<int> ans(n, 0);
        vector<int> h(n, 0);
        for (int i = 0; i < n; ++i) {
            int l = positions[i][0];
            int r = l + positions[i][1];
            int cur = positions[i][1];
            for (int j = i - 1; j >= 0; --j) {
                int l1 = positions[j][0];
                int r1 = l1 + positions[j][1];
                if (l1 >= r || r1 <= l) {
                    continue;
                }
                cur = max(cur, h[j] + positions[i][1]);
            }
            h[i] = cur;
            ans[i] = i == 0 ? h[0] : max(cur, ans[i - 1]);
        }
        return ans;
    }
};