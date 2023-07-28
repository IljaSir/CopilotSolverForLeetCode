class Solution {
public:
    string sortString(string s) {
        
        int n = s.size();
        int cnt[26] = {0};
        for (char ch : s) {
            cnt[ch - 'a']++;
        }
        string ans;
        while (ans.size() < n) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    ans += 'a' + i;
                    cnt[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (cnt[i] > 0) {
                    ans += 'a' + i;
                    cnt[i]--;
                }
            }
        }
        return ans;
    }
};