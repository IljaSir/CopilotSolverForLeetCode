class Solution {
public:
    int longestSubstring(string s, int k) {
        
        int n = s.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt[26] = {0};
            int mask = 0;
            for (int j = i; j < n; j++) {
                int t = s[j] - 'a';
                cnt[t]++;
                if (cnt[t] < k) mask |= (1 << t);
                else mask &= (~(1 << t));
                if (mask == 0) res = max(res, j - i + 1);
            }
        }
        return res;
    }
};