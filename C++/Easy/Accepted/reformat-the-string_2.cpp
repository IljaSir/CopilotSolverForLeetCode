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
        if (abs(int(alpha.size()) - int(digit.size())) > 1) {
            return "";
        }
        string res;
        if (alpha.size() > digit.size()) {
            for (int i = 0; i < digit.size(); ++i) {
                res.push_back(alpha[i]);
                res.push_back(digit[i]);
            }
            res.push_back(alpha.back());
        } else {
            for (int i = 0; i < alpha.size(); ++i) {
                res.push_back(digit[i]);
                res.push_back(alpha[i]);
            }
            if (digit.size() > alpha.size()) {
                res.push_back(digit.back());
            }
        }
        return res;
    }
};