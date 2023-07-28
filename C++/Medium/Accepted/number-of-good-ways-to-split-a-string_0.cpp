class Solution {
public:
    int numSplits(string s) {
        
        int n = s.size();
        vector<int> left(26, 0), right(26, 0);
        for (int i = 0; i < n; ++i) {
            ++right[s[i] - 'a'];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            ++left[s[i] - 'a'];
            --right[s[i] - 'a'];
            int l = 0, r = 0;
            for (int j = 0; j < 26; ++j) {
                if (left[j] > 0) ++l;
                if (right[j] > 0) ++r;
            }
            if (l == r) ++res;
        }
        return res;
    }
};