class Solution {
public:
    int balancedString(string s) {
        
        int n = s.length();
        int k = n / 4;
        unordered_map<char, int> cnt;
        for (char c : s) {
            cnt[c]++;
        }
        int l = 0;
        int r = 0;
        int res = n;
        while (r < n) {
            cnt[s[r]]--;
            while (l <= r && cnt['Q'] <= k && cnt['W'] <= k && cnt['E'] <= k && cnt['R'] <= k) {
                res = min(res, r - l + 1);
                cnt[s[l]]++;
                l++;
            }
            r++;
        }
        return res;
    }
};