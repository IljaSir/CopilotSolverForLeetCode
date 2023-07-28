class Solution {
public:
    string sortString(string s) {
        
        string res;
        int n = s.length();
        int cnt[26] = {0};
        for (int i = 0; i < n; i++) {
            cnt[s[i] - 'a']++;
        }
        while (res.length() < n) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    res += (i + 'a');
                    cn[i]--
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (cnt[i] > 0) {
                    res += (i + 'a');
                    cnt[i]--;
                }
            }
        }
        return res;
    }
};