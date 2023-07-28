class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        
        int result = -1;
        for (int i = 0; i < s.size(); ++i) {
            for (int j = s.size() - 1; j > i; --j) {
                if (s[i] == s[j]) {
                    result = max(result, j - i - 1);
                }
            }
        }
        return result;
    }
};