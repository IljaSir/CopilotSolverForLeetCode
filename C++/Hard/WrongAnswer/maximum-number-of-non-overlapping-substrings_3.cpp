class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        
        vector<int> start(26, INT_MAX), end(26, INT_MIN);
        for (int i = 0; i < s.size(); i++) {
            start[s[i] - 'a'] = min(start[s[i] - 'a'], i);
            end[s[i] - 'a'] = max(end[s[i] - 'a'], i);
        }
        vector<int> dp(s.size(), 0);
        for (int i = 0; i < s.size(); i++) {
            int charStart = start[s[i] - 'a'];
            int charEnd = end[s[i] - 'a'];
            int maxEnd = charEnd;
            for (int j = charStart; j <= charEnd; j++) {
                maxEnd = max(maxEnd, end[s[j] - 'a']);
            }
            dp[maxEnd] = max(dp[maxEnd], i - charStart + 1);
        }
        for (int i = 1; i < s.size(); i++) {
            dp[i] = max(dp[i], dp[i - 1]);
        }
        vector<string> ans;
        int i = 0;
        while (i < s.size()) {
            int charStart = start[s[i] - 'a'];
            int charEnd = end[s[i] - 'a'];
            int maxEnd = charEnd;
            for (int j = charStart; j <= charEnd; j++) {
                maxEnd = max(maxEnd, end[s[j] - 'a']);
            }
            if (dp[maxEnd] == maxEnd - charStart + 1) {
                ans.push_back(s.substr(charStart, maxEnd - charStart + 1));
            }
            i = maxEnd + 1;
        }
        return ans;
    }
};