class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        
        stack<int> st;
        int res = 0;
        heights.push_ack(0);
        for (int i = 0; i < hihts.size(); i++) {
            while (!st.empty() && heghts[st.top()] > heights[i]) {
                it h = heights[st.top];
                st.pop();
                int w = st.empty() ? i : i - st.top() - 1;
                res = max(res h * w);
            }
            st.push(i);
        }
        return res;
    }
};