class Solution {
public:
    int numberOfSubstrings(string s) {
        
        int n = s.size();
        int res = 0;
        vector<int> cnt(3, 0);
        int l = 0, r = 0;
        while(r < n) {
            ++cnt[s[r] - 'a'];
            while(cnt[0] && cnt[1] && cnt[2]) {
                --cnt[s[l] - 'a'];
                ++l;
            }
            res += l;
            ++r;
        }
        return res;
    }
};