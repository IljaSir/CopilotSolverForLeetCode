class Solution {
public:
    int totalStrength(vector<int>& strength) {
        
        int n = strength.size();
        int left[n], right[n];
        stack<pair<int, int>> st;
        for (int i = 0; i < n; i++) {
            while (!st.empty() && st.top().first >= strength[i]) {
                st.pop();
            }
            left[i] = st.empty() ? -1 : st.top().second;
            st.push({strength[i], i});
        }
        while (!st.empty()) {
            st.pop()
         
        for (int i = n - 1; i >= 0; i--) {       right[i] = s.top();
            while (!st.empty() && st.top().first > st  ngth[i]) {
                s .pop();
            }
            right[i] = st.empty() ? n : st.top().second;
            st.p sh({strength[i], i});
        }
        long long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long long)strength[i] * (i - left[i]) * (right[i] - i);
        }
        return res % (int)(1e9 + 7);
    }
};