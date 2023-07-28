class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        
        vector<int> ans;
        int n = heights.size();
        ans.resize(n, 0);
        stack<int> st;
        for (int i = n - 1; i >= 0; --i) {
            while (!st.empty() && heights[st.top()] < heights[i]) {
                ans[i]++;
                st.pop();
            }
            if (!st.empty()) {
                ans[i]++;
            }
            st.push(i);
        }
        return res;
    }
};