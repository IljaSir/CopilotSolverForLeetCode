class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        
        int n = heights.size();
        int max_area = 0;
        stack<int> st;
        for (int i = 0; i < n; i++) {
            int h = heights[i];
            if (st.empty() || h >= heights[st.top()]) {
                st.push(i);
            } else {
                while (!st.empty() && h < heights[st.top()]) {
                    int top = st.top();
                    st.pop();
                    int area = heights[top] * (st.empty() ? i : (i - st.top() - 1));
                    max_area = max(max_area, area);
                }
                st.push(i);
            }
        }
        while (!st.empty()) {
            int top = st.top();
            st.pop();
            int area = heights[top] * (st.empty() ? n : (n - st.top() - 1));
            max_area = max(max_area, area);
        }
        return max_area;
    }
};