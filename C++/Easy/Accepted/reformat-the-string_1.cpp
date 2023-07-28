class Solution {
public:
    string reformat(string s) {
        
        string alpha, digit;
        for (char c : s) {
            if (isdigit(c)) {
                digit.push_back(c);
            } else {
                alpha.push_back(c);
            }
        }
        if (abs((int)alpha.length() - (int)digit.length()) > 1) {
            return "";
        }
        if (alpha.length() > digit.length()) {
            return reformat(alpha, digit);
        } else {
            return reformat(digit, alpha);
        }
    }
    
    string reformat(const string& l, const string& s) {
        string ans;
        for (int i = 0; i < s.length(); ++i) {
            ans.push_back(l[i]);
            ans.push_back(s[i]);
        }
        if (l.length() > s.length()) {
            ans.push_back(l.back());
        }
        return ans;
    }
};