class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        
        heights.insert(heights.begin(), 0);
        heights.push_back(0);
        stack<int> st;
        int ans = 0;
        for (int i = 0; i < heights.size(); i++) {
            while (!st.empty() && heights[st.top()] > heights[i]) {
                int h = heights[st.top()];
                st.pop();
                int l = st.top();
                int r = i;
                ans = max(ans, h * (r - l - 1));
            }
            st.push(i);
        }
        return ans;
    }
};