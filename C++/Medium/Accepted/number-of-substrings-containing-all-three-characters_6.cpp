class Solution {
public:
    int numberOfSubstrings(string s) {
        
        int cnt[3] = { 0, 0, 0 };
        int res = 0, l = 0;
        for (int i = 0; i < s.size(); ++i) {
            ++cnt[s[i] - 'a'];
            while (cnt[0] && cnt[1] && cnt[2]) {
                --cnt[s[l++] - 'a'];
            }
            res += l;
        }
        return res;
    }
};