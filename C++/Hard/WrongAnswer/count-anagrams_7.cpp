class Solution {
public:
    int countAnagrams(string s) {
        
        int n = s.size();
        int mod = 1e9 + 7;
        vector<long long> dp(n, 0);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else {
                dp[i] = (dp[i - 1] * 26) % mod;
            }
        }
        long long ans = 0;
        unordered_map<string, int> cnt;
        string word = "";
        for (int i = 0; i < n; i++) {
            if (s[i] == ' ') {
                cnt[word]++;
                word = "";
            } else {
                word += s[i];
            }
        }
        cnt[word]++;
        for (auto& [_, v] : cnt) {
            ans = (ans + dp[v - 1]) % mod;
        }
        return ans;
    }
};