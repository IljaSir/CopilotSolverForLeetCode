class Solution {
public:
    int longestContinuousSubstring(string s) {
        
        int result = 0;
        int i = 0;
        int j = 0;
        while (i < s.size()) {
            j = i + 1;
            while (j < s.size() && s[j] > s[j - 1]) {
                ++j;
            }
            result = max(result, j - i);
            i = j;
        }
        return result;
    }
};