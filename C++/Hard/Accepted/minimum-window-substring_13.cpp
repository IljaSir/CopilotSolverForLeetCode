class Solution {
public:
    string minWindow(string s, string t) {
        
        int n = s.length();
        int m = t.length();
        vector<int> cnt(128, 0);
        for (char ch: t) {
            cnt[ch]++;
        }
        int l = 0;
        int r = 0;
        int minL = 0;
        int minR = 0;
        int minLen = INT_MAX;
        int total = 0;
        while (r < n) {
            if (cnt[s[r]] > 0) {
                total++;
            }
            cnt[s[r]]--;
            r++;
            while (total == m) {
                if (r - l < minLen) {
                    minLen = r - l;
                    minL = l;
                    minR = r;
                }
                if (cnt[s[l]] == 0) {
                    total--;
                }
                cnt[s[l]]++;
                l++;
            }
        }
        return minLen == INT_MAX ? "" : s.substr(minL, minLen);
    }
};