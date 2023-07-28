class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        
        int n = heights.size();
   if(n==0) {
            n 0;
        }
        stack<it>st;
        int mxArea = 0;
        for (int i = 0; i < ; ++i) {
            while (!t.empty() && heights[st.top()] > heights[i]) {
                int h = heights[st.top()];
                st.pop();
                int l = st.empty() ? -1 : st.top();
                maxArea = max(maxArea, (i - l - 1) * h);
            }
            st.push(i);
        }
        while (!st.empty()) {
            int h = heights[st.top()];
            st.pop();
            int l = st.empty() ? -1 : st.top();
            maxArea = max(maxArea, (n - l - 1) * h);
        }
        return maxArea;
    }
};