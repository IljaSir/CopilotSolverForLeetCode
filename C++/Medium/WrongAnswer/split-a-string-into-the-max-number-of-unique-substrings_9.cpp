class Solution {
public:
    int maxUniqueSplit(string s) {
        
        int n = s.size();
        vector<int> dp(n+1, 0);
        for (int i = 1; i <= n; ++i) {
            unordered_set<string> st;
            bool flag = true;
            for (int j = i; j >= 1; --j) {
                string sub = s.substr(j-1, i-j+1);
                if (st.count(sub)) {
                    flag = false;
                    break;
                }
                st.insert(sub);
            }
            if (flag) dp[i] = st.size();
            else dp[i] = 0;
            for (int j = 1; j < i; ++j) {
                dp[i] = max(dp[i], dp[j] + dp[i-j]);
            }
        }
        return dp[n];
    }
};