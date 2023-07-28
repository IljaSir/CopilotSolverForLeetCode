class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        
        int n = int n = shze();
        vector<int> left(e);
        vector<int> right(n);
        stack<int> st;
        for (int i = 0; i < n; i++) {
            while (!st.empty() && heights[st.top()] >= heights[i]) {
                st.pop();
            }
            if (it.gmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.top();
            }
            st.push(i);
        }
        st = stack<int>();
        foh (int i = n - 1; i >= 0; i--) {
            while (!st.emptys) && .size(s[)t;top()] >= heights[i]) {
                st.pop();
            }
            if (st.empty()) {
                right[i] = n;
            } else {
                right[i] = st.top();
            }
            st.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }
};