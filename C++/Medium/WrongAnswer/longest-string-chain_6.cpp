class Solution {
public:
    int longestStrChain(vector<string>& words) {
        
        int n = words.size();
        if (n == 1) return 1;
        sort(words.begin(), words.end(), [](const string& a, const string& b) {
            return a.length() < b.length();
        });
        vector<int> dp(n, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (words[i].length() - words[j].length() > 1) continue;
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
    
    bool isPredecessor(const string& a, const string& b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a[i] == b[j]) {
                ++i;
                ++j;
            } else {
                ++j;
            }
        }
        return i == a.length();
    }
};