class Solution {
public:
    string reformat(string s) {
        
        string letter, digit;
        string res;
        for (auto c : s) {
            if (isalpha(c)) {
                letter.push_back(c);
            } else {
                digit.push_back(c);
            }
        }
        if (abs(int(letter.size()) - int(digit.size())) > 1) {
            return "";
        }
        if (letter.size() > digit.size()) {
            for (int i = 0; i < letter.size(); ++i) {
                res.push_back(letter[i]);
                if (i < digit.size()) {
                    res.push_back(digit[i]);
                }
            }
        } else {
            for (int i = 0; i < digit.size(); ++i) {
                res.push_back(digit[i]);
                if (i < letter.size()) {
                    res.push_back(letter[i]);
                }
            }
        }
        return res;
    }
};