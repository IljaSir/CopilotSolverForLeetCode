class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        
        int n = heights.size();
        if (n == 0) return 0;
        if (n == 1) return heights[0];
        stack<int> stk;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            if (stk.empty() || heights[i] > heights[stk.top()]) {
                stk.push(i);
            } else {
                while (!stk.empty() && heights[i] <= heights[stk.top()]) {
                    int top = stk.top();
                    stk.pop();
                    int left = stk.empty() ? -1 : stk.top();
                    maxArea = max(maxArea, heights[top] * (i - left - 1));
                }
                stk.push(i);
            }
        }
        while (!stk.empty()) {
            int top = stk.top();
            stk.pop();
            int left = stk.empty() ? -1 : stk.top();
            maxArea = max(maxArea, heights[top] * (n - left - 1));
        }
        return maxArea;
    }
};