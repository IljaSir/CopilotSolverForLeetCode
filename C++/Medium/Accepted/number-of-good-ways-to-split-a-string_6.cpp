class Solution {
public:
    int numSplits(string s) {
        
        int n = s.size();
        int left[26] = {0};
        int right[26] = {0};
        int cntl = 0;
        int cntr = 0;
        for (int i = 0; i < n; ++i) {
            if (right[s[i] - 'a'] == 0) {
                ++cntr;
            }
            ++right[s[i] - 'a'];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (left[s[i] - 'a'] == 0) {
                ++cntl;
            }
            ++left[s[i] - 'a'];
            --right[s[i] - 'a'];
            if (right[s[i] - 'a'] == 0) {
                --cntr;
            }
            if (cntl == cntr) {
                ++res;
            }
        }
        return res;
    }
};