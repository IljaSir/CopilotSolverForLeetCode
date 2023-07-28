class Solution {
public:
    int countBinarySubstrings(string s) {
        
        int count = 0;
        int n = s.size();
        int pre = 0;
        int cur = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] == s[i - 1]) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                count++;
            }
        }
        return count;
    }
};