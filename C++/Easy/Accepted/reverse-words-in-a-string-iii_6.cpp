class Solution {
public:
    string reverseWords(string s) {
        
        string res = "";
        int n = s.length();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s[j] != ' ') {
                j++;
            }
            for (int k = j - 1; k >= i; k--) {
                res.push_back(s[k]);
            }
            while (j < n && s[j] == ' ') {
                res.push_back(s[j]);
                j++;
            }
            i = j;
        }
        return res;
    }
};