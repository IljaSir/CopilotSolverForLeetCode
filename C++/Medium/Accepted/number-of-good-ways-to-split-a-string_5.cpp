class Solution {
public:
    int numSplits(string s) {
        
        int n = s.length();
        vector<int> left(26, 0);
        vector<int> right(26, 0);
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < n; ++i) {
            if (right[s[i] - 'a'] == 0) {
                ++rightCount;
            }
            ++right[s[i] - 'a'];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[s[i] - 'a'] == 0) {
                ++leftCount;
            }
            ++left[s[i] - 'a'];
            --right[s[i] - 'a'];
            if (right[s[i] - 'a'] == 0) {
                --rightCount;
            }
            if (leftCount == rightCount) {
                ++ans;
            }
        }
        return ans;
    }
};