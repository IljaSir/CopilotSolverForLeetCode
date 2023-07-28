class Solution {
public:
    int countAnagrams(string s) {
        
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt[26] = {0};
            int j = i;
            while (j < n && s[j] != ' ') {
                cnt[s[j] - 'a']++;
                j++;
            }
            i = j;
            for (int k = 0; k < 26; k++) {
                ans += (cnt[k] * (cnt[k] - 1)) / 2;
            }
        }
        return ans;
    }
};