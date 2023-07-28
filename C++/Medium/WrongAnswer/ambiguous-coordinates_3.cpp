class Solution {
public:
    vector<string> ambiguousCoordinates(string s) {
        
        vector<string> ret;
        for (int i = 2; i < s.length() - 1; i++) {
            vector<string> left = getValid(s.substr(1, i - 1));
            vector<string> right = getValid(s.substr(i, s.length() - i - 1));
            for (string l : left) {
                for (string r : right) {
                    ret.push_back("(" + l + ", " + r + ")");
                }
            }
        }
        return ret;
    }
    vector<string> getValid(string s) {
        vector<string> ret;
        if (s.length() == 1 || s[0] != '0') {
            ret.push_back(s);
        }
        if (s.length() > 1 && s[s.length() - 1] != '0') {
            for (int i = 1; i < s.length(); i++) {
                ret.push_back(s.substr(0, i) + "." + s.substr(i));
            }
        }
        return ret;
    }
};