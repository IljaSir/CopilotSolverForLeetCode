class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        
        int n = heights.size();
        if (n == 0) return 0;
        if (n == 1) return heights[0];
        vector<int> left(n, -1);
        vector<int> right(n, n);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            while (!s.empty() && heights[s.top()] >= heights[i]) {
                right[s.top()] = i;
                s.pop();
            }
            if (!s.empty()) left[i] = s.top();
            s.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
};