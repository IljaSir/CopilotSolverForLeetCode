class Solution {
public:
    string reverseWords(string s) {
        
        int n = s.size();
        int i = 0;
        string ans;
        while (i < n) {
            while (i < n && s[i] == ' ') ++i;
            if (i >= n) break;
            string tmp;
            while (i < n && s[i] != ' ') {
                tmp += s[i];
                ++i;
            }
            if (ans.size() > 0) ans = tmp + ' ' + ans;
            else ans = tmp;
        }
        return ans;
    }
};