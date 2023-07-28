class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int n = s.size();
        int l = 0, r = 0, maxCnt = 0;
        vector<int> cnt(26, 0);
        while (r < n) {
            cnt[s[r] - 'A']++;
            maxCnt = max(maxCnt, cnt[s[r] - 'A']);
            if (r - l + 1 > maxCnt + k) {
                cnt[s[l] - 'A']--;
                l++;
            }
            r++;
        }
        return r - l;
    }
};