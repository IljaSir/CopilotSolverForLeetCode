class Solution {
public:
    int numberOfSubstrings(string s) {
        
        int cnt[3]{};
        int n = s.size();
        int i = 0, j = 0;
        int ans = 0;
        while (j < n) {
            cnt[s[j++] - 'a']++;
            while (cnt[0] && cnt[1] && cnt[2]) {
                cnt[s[i++] - 'a']--;
            }
            ans += i;
        }
        return ans;
    }
};