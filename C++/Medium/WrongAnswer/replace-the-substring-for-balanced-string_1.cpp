class Solution {
public:
    int balancedString(string s) {
        
        unordered_map<char, int> cnt;
        for (char c : s) {
            cnt[c]++;
        }
        int n = s.size();
        int need = n / 4;
        int l = 0, r = 0;
        int ans = n;
        while (r < n) {
            cnt[s[r]]--;
            while (l <= r && cnt['Q'] <= need && cnt['W'] <= need && cnt['E'] <= need && cnt['R'] <= need) {
                ans = min(ans, r - l + 1);
                cnt[s[l]]++;
                l++;
            }
            r++;
        }
        return ans;
    }
};