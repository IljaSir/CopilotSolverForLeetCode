class Solution {
public:
    int numberOfSubstrings(string s) {
        
        int n = s.size();
        int l = 0, r = 0;
        int ans = 0;
        int cnt[3] = {0};
        while (r < n) {
            cnt[s[r] - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                cnt[s[l] - 'a']--;
                l++;
            }
            ans += l;
            r++;
        }
        return ans;
    }
};