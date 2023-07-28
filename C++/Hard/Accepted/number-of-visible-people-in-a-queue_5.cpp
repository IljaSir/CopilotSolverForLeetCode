class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        
        int n = heights.size();
        vector<int> res(n, 0);
        stack<int> st;
        for (int i = 0; i < n; i++) {
            while (!st.empty() && heights[st.top()] <= heights[i]) {
                res[st.top()]++;
                st.pop();
            }
            if (!st.empty()) res[st.top()]++;
            st.push(i);
        }
        return res;
    }
};