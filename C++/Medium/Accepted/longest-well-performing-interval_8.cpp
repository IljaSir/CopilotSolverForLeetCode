class Solution {
public:
    int longestWPI(vector<int>& hours) {
        
        int n = hours.size();
        int res = 0;
        vector<int> score(n+1, 0);
        for (int i = 0; i < n; ++i) {
            score[i+1] = score[i] + (hours[i] > 8 ? 1 : -1);
        }
        stack<int> st;
        for (int i = 0; i < n+1; ++i) {
            if (st.empty() || score[st.top()] > score[i]) {
                st.push(i);
            }
        }
        for (int i = n; i >= 0; --i) {
            while (!st.empty() && score[st.top()] < score[i]) {
                res = max(res, i - st.top());
                st.pop();
            }
        }
        return res;
    }
};