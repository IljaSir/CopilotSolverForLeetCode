class Solution {
public:
    int rearrangeCharacters(string s, string target) {
        
        vector<int> cnt(26, 0);
        for (auto c : s) cnt[c - 'a']++;
        vector<int> tcnt(26, 0);
        for (auto c : target) tcnt[c - 'a']++;
        int n = target.length();
        int m = s.length();
        int res = 0;
        while (true) {
            for (int i = 0; i < 26; ++i) {
                if (tcnt[i] > 0) {
                    if (cnt[i] == 0) return res;
                    cnt[i]--;
                }
            }
            res++;
        }
        return res;
    }
};