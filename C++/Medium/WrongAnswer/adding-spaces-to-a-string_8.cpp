class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        
        int n = s.size();
        int m = spaces.size();
        if (m == 0) return s;
        string res;
        res.reserve(n + m);
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            res += s[i++];
            if (i == spaces[j]) {
                res += ' ';
                ++j;
            }
        }
        while (i < n) {
            res += s[i++];
        }
        return res;
    }
};