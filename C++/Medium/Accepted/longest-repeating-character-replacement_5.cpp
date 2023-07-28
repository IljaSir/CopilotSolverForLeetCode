class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int n = s.size();
        int l = 0, r = 0;
        int ans = 0;
        int maxCnt = 0;
        vector<int> cnt(26, 0);
        while (r < n) {
            cnt[s[r] - 'A']++;
            maxCnt = max(maxCnt, cnt[s[r] - 'A']);
            while (r - l + 1 - maxCnt > k) {
                cnt[s[l] - 'A']--;
                l++;
            }
            ans = max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
};