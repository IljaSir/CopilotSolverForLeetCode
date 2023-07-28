class Solution {
public:
    int lengthOfLastWord(string s) {
        
        int l = s.length();
        int i = l - 1;
        while (i >= 0 && s[i] == ' ') {
            i--;
        }
        int len = 0;
        while (i >= 0 && s[i] != ' ') {
            len++;
            i--;
        }
        return len;
    }
};