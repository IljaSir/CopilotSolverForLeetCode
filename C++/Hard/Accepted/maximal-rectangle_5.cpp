class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        
        int m = matrix.size();
        if (m == 0) return 0;
        int n = matrix[0].size();
        if (n == 0) return 0;
        int maxArea = 0;
        vector<int> height(n+1, 0);
        for (int i = 0; i < m; ++i) {
            stack<int> s;
            for (int j = 0; j < n+1; ++j) {
                if (j < n) {
                    if (matrix[i][j] == '1') {
                        height[j] += 1;
                    } else {
                        height[j] = 0;
                    }
                }
                while (!s.empty() && height[j] < height[s.top()]) {
                    int h = height[s.top()];
                    s.pop();
                    int w = s.empty() ? j : j - s.top() - 1;
                    maxArea = max(maxArea, h * w);
                }
                s.push(j);
            }
        }
        return maxArea;
    }
};