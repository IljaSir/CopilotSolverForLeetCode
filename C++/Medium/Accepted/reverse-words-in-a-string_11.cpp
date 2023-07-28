class Solution {
public:
    string reverseWords(string s) {
        
        string ans = "";
        int j = s.length() - 1;
        int i = j;
        while (i >= 0) {
            while (i >= 0 && s[i] == ' ') i--;
            j = i;
            while (i >= 0 && s[i] != ' ') i--;
            if (j > i) {
                if (ans.length() > 0) ans += " ";
                ans += s.substr(i + 1, j - i);
            }
        }
        return ans;
    }
};