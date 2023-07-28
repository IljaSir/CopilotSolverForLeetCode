class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        
        int n = heights.size();
        vector<int> result(n, 0);
        stack<int> st;
        for (int i = n - 1; i >= 0; --i) {
            int count = 0;
            while (!st.empty() && st.top() <= heights[i]) {
                st.pop();
                ++count;
            }
            if (!st.empty()) {
                ++count;
            }
            st.push(heights[i]);
            result[i] = count;
        }
        return result;
    }
};