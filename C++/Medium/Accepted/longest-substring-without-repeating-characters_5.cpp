class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int n = s.size();
        vector<int> last(256, -1);
        int i = 0;
        int res = 0;
        for (int j = 0; j < n; j++) {
            i = max(i, last[s[j]] + 1);
            res = max(res, j - i + 1);
            last[s[j]] = j;
        }
        return res;
    }
};