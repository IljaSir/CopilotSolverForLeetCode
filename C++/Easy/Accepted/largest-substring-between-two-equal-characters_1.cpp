class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s[i] == s[j]) {
                    int temp = j - i - 1;
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        
        return max;
    }
};