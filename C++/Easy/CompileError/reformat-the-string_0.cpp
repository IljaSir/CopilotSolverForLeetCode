class Solution {
public:
    string reformat(string s) {
        
        string digits;
        string letters;
        for (int i = 0; i < s.size(); i++) {
            if (isdigit(s[i])) {
                digits += s[i];
            } else {
                letters += s[i];
            }
        }
        if (abs(digits.size() - letters.size()) > 1) {
            return "";
        }
        string ans;
        int i = 0;
        int j = 0;
        if (digits.size() > letters.size()) {
            ans += digits[i++];
        } else {
            ans += letters[j++];
        }
        while (i < digits.size() && j < letters.size()) {
            if (isdigit(ans.back())) {
                ans += letters[j++];
            } else {
                ans += digits[i++];
            }
        }
        return ans;
    }
};