class Solution {
public:
    string reformat(string s) {
        
        string alpha, digit;
        for (auto c : s) {
            if (isalpha(c)) {
                alpha.push_back(c);
            } else {
                digit.push_back(c);
            }
        }
        if (abs(int(alpha.size()) - int(digit.size())) > 1) {
            return "";
        }
        string ans;
        if (alpha.size() > digit.size()) {
            for (int i = 0; i < digit.size(); ++i) {
                ans.push_back(alpha[i]);
                ans.push_back(digit[i]);
            }
            ans.push_back(alpha.back());
        } else if (digit.size() > alpha.size()) {
            for (int i = 0; i < alpha.size(); ++i) {
                ans.push_back(digit[i]);
                ans.push_back(alpha[i]);
            }
            ans.push_back(digit.back());
        } else {
            for (int i = 0; i < alpha.size(); ++i) {
                ans.push_back(alpha[i]);
                ans.push_back(digit[i]);
            }
        }
        return ans;
    }
};