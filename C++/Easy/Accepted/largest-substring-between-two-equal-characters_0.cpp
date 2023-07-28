class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s[i] == s[j]) {
                    res = max(res, j - i - 1);
                    break;
                }
            }
        }
        return res;
    }
};