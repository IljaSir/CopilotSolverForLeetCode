class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        
        int max = -1;
        for (int i = 0; i < s.size(); ++i) {
            for (int j = i+1; j < s.size(); ++j) {
                if (s[i] == s[j]) {
                    if (j - i - 1 > max) {
                        max = j - i - 1;
                    }
                }
            }
        }
        return max;
    }
};