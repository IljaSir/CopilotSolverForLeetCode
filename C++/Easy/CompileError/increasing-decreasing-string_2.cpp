class Solution {
public:
    string sortString(string s) {
        
        int cnt[26] = {0};
        for (char c: s) cnt[c - 'a']++;
        string ans;
        while (ans.size() < s.size()) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i]) {
                    ans += 'a' + i;
                    cnt[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (cnt[i]) {
                    ans += 'a' + i;
                    cnt[i]--;
                }
            }
        }
        return ans;lt;
    }
};