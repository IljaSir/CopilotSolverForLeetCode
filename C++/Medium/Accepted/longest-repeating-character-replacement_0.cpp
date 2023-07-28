class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int n = s.size();
        vector<int> cnt(26, 0);
        int l = 0;
        int maxCnt = 0;
        int res = 0;
        for (int r = 0; r < n; r++) {
            maxCnt = max(maxCnt, ++cnt[s[r] - 'A']);
            while (r - l + 1 - maxCnt > k) {
                cnt[s[l] - 'A']--;
                l++;
            }
            res = max(res, r - l + 1);
        }
        return res;
    }
};