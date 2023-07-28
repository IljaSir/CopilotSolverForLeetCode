class Solution {
public:
    int balancedString(string s) {
        
        int n = s.length();
        int k = n / 4;
        vector<int> cnt(128);
        for (char c: s) ++cnt[c];
        int l = 0, r = 0, res = n;
        while (r < n) {
            --cnt[s[r]];
            while (l <= r && cnt['Q'] <= k && cnt['W'] <= k && cnt['E'] <= k && cnt['R'] <= k) {
                res = min(res, r - l + 1);
                ++cnt[s[l++]];
            }
            ++r;
        }
        return res;
    }
};