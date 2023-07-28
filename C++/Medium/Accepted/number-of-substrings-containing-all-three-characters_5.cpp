class Solution {
public:
    int numberOfSubstrings(string s) {
        
        int n = s.size();
        int i = 0, j = 0, ans = 0;
        vector<int> cnt(3, 0);
        while (j < n) {
            cnt[s[j++] - 'a']++;
            while (i < j && cnt[0] && cnt[1] && cnt[2]) {
                ans += n - j + 1;
                cnt[s[i++] - 'a']--;
            }
        }
        return ans;
    }
};