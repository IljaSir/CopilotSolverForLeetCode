class Solution {
public:
    int maxVowels(string s, int k) {
        
        int res = 0;
        int n = s.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i < k) {
                cnt += isVowel(s[i]);
            } else {
                res = max(res, cnt);
                cnt += isVowel(s[i]) - isVowel(s[i - k]);
            }
        }
        res = max(res, cnt);
        return res;
    }
};