class Solution {
public:
    int appendCharacters(string s, string t) {
        
        int i = s.length() - 1, j = t.length() - 1;
        int count = 0;
        while (i >= 0 && j >= 0) {
            if (s[i] == t[j]) {
                i--;
                j--;
            } else {
                i--;
                count++;
            }
        }
        return count + j + 1;
    }
};