class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        
        string res = "";
        int i = 0;
        for (int j = 0; j < spaces.size(); ++j) {
            while (i < spaces[j]) {
                res += s[i++];
            }
            res += ' ';
        }
        while (i < s.size()) {
            res += s[i++];
        }
        return res;
    }
};