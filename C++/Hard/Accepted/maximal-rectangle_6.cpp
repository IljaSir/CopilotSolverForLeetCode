class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        
        int m = matrix.size();
        if (m == 0) return 0;
        int n = matrix[0].size();
        if (n == 0) return 0;
        vector<int> height(n + 1, 0);
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            stack<int> stk;
            for (int j = 0; j < n + 1; ++j) {
                while (!stk.empty() && height[j] < height[stk.top()]) {
                    int cur = stk.top();
                    stk.pop();
                    if (stk.empty()) ans = max(ans, height[cur] * j);
                    else ans = max(ans, height[cur] * (j - stk.top() - 1));
                }
                stk.push(j);
            }
        }
        return ans;
    }
};