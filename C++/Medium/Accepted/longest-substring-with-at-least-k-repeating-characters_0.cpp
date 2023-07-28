class Solution {
public:
    int longestSubstring(string s, int k) {
        
        int n = s.size();
        int ans = 0;
        for (int t = 1; t <= 26; t++) {
            vector<int> cnt(26);
            int total = 0, less = 0;
            int l = 0, r = 0;
            while (r < n) {
                cnt[s[r] - 'a']++;
                if (cnt[s[r] - 'a'] == 1) {
                    total++;
                    less++;
                }
                if (cnt[s[r] - 'a'] == k) {
                    less--;
                }
                while (total > t) {
                    cnt[s[l] - 'a']--;
                    if (cnt[s[l] - 'a'] == k - 1) {
                        less++;
                    }
                    if (cnt[s[l] - 'a'] == 0) {
                        total--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    ans = max(ans, r - l + 1);
                }
                r++;
            }
        }
        return ans;
    }
};