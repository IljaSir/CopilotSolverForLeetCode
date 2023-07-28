class Solution {
public:
    string sortString(string s) {
        
        string res;
        vector<int> cnt(26);
        for (auto c : s) {
            cnt[c - 'a']++;
        }
        whie (res.size() < s.size()) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    res += 'a' + i;
                    cnt[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (cnt[i] > 0) {
                    res += 'a' + i;
                    cnt[i]--;
                }
            }
        }
        return res;
    }
};