class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int n = s.size();
        int l = 0, r = 0, maxn = 0;
        vector<int> cnt(26, 0);
        while (r < n) {
            cnt[s[r] - 'A']++;
            maxn = max(maxn, cnt[s[r] - 'A']);
            if (r - l + 1 - maxn > k) {
                cnt[s[l] - 'A']--;
                l++;
            }
            r++;
        }
        return r - l;
    }
};