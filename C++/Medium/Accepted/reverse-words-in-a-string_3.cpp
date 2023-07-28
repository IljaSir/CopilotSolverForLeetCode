class Solution {
public:
    string reverseWords(string s) {
        
        string res;
        int n = s.size();
        int i = n - 1;
        while (i >= 0) {
            if (s[i] == ' ') {
                i--;
                continue;
            }
            int j = i;
            while (j >= 0 && s[j] != ' ') {
                j--;
            }
            if (res.size() > 0) {
                res += " ";
            }
            res += s.substr(j + 1, i - j);
            i = j;
        }
        return res;
    }
};