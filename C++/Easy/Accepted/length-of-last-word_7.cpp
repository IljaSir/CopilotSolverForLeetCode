class Solution {
public:
    int lengthOfLastWord(string s) {
        
        int len = s.length();
        int i = len - 1;
        int cnt = 0;
        while (i >= 0 && s[i] == ' ') i--;
        while (i >= 0 && s[i] != ' ') {
            i--;
            cnt++;
        }
        return cnt;
    }
};