class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        
        int n = s.size();
        int m = spaces.size();
        string res = "";
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (i < spaces[j]) {
                res += s[i++];
            } else {
                res += ' ';
                j++;
            }
        }
        while (i < n) {
            res += s[i++];
        }
        return res;
    }
};