class Solution {
public:
    string reverseWords(string s) {
        
        string res;
        int i = 0;
        while (i < s.size()) {
            int j = i;
            while (j < s.size() && s[j] != ' ') {
                j++;
            }
            reverse(s.begin() + i, s.begin() + j);
            res += s.substr(i, j - i) + " ";
            i = j + 1;
        }
        res.pop_back();
        return res;
    }
};