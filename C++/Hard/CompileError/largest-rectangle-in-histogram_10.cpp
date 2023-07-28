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
        return max_area
        int n = heights.size();
        if (n == 0) return 0;
        if (n == 1) return heights[0];
        vector<int> left(n, -1), right(n, n);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            while (!s.empty() && heights[s.top()] >= heights[i]) s.pop();
            if (!s.empty()) left[i] = s.top();
            s.push(i);
        }
        s = stack<int>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && heights[s.top()] >= heights[i]) s.pop();
            if (!s.empty()) right[i] = s.top();
            s.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
};