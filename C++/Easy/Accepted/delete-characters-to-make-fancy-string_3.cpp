class Solution {
public:
    string makeFancyString(string s) {
        
        int n = s.size();
        string ret;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s[j] == s[i]) ++j;
            int cnt = j - i;
            if (cnt < 3) {
                ret += s.substr(i, cnt);
            } else {
                ret += s.substr(i, 2);
            }
            i = j;
        }
        return ret;
    }
};