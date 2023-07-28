class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        
        int l = s.length(), ans = -1;
        for (int i = 0; i < l; i++) {
            for (int j = l - 1; j > i; j--) {
                if (s[i] == s[j]) {
                    ans = max(ans, j - i - 1);
                    break;
                }
            }
        }
        return ans;
    }
};