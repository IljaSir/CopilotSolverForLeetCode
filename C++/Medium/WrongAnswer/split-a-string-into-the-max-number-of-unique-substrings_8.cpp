class Solution {
public:
    int maxUniqueSplit(string s) {
        
        int n = s.size();
        int ans = 0;
        vector<int> dp(n + 1, 0);
        unordered_set<string> st;
        function<void(int)> dfs = [&](int i) {
            if (i >= n) {
                ans = max(ans, dp[i]);
                return;
            }
            for (int j = i; j < n; j++) {
                string ss = s.substr(i, j - i + 1);
                if (st.count(ss)) continue;
                st.insert(ss);
                dp[j + 1] = max(dp[j + 1], dp[i] + 1);
                dfs(j + 1);
                st.erase(ss);
            }
        };
        dfs(0);
        return ans;
    }
};