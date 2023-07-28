class Solution {
public:
    int numSplits(string s) {
        
        int n = s.size();
        vector<int> left(26, 0), right(26, 0);
        int leftCount = 0, rightCount = 0;
        for (int i = 0; i < n; ++i) {
            if (right[s[i] - 'a'] == 0) {
                ++rightCount;
            }
            ++right[s[i] - 'a'];
        }
        int res = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (left[s[i] - 'a'] == 0) {
                ++leftCount;
            }
            ++left[s[i] - 'a'];
            --right[s[i] - 'a'];
            if (right[s[i] - 'a'] == 0) {
                --rightCount;
            }
            if (leftCount == rightCount) {
                ++res;
            }
        }
        return res;
    }
};