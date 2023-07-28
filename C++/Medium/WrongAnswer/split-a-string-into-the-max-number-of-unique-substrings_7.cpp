class Solution {
public:
    int maxUniqueSplit(string s) {
        
        int n = s.length();
        vector<int> dp(n, 0);
        unordered_set<string> st;
        for (int i = 0; i < n; ++i) {
            string sub = s.substr(0, i + 1);
            if (st.find(sub) == st.end()) {
                st.insert(sub);
                dp[i] = 1;
            }
            for (int j = 0; j < i; ++j) {
                if (dp[j] == 0) {
                    continue;
                }
                sub = s.substr(j + 1, i - j);
                if (st.find(sub) == st.end()) {
                    st.insert(sub);
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            st.clear();
        }
        return dp[n - 1];
    }
};