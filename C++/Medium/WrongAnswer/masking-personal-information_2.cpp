class Solution {
public:
    string maskPII(string s) {
        
        int pos = s.find('@');
        if (pos != string::npos) {
            // email
            s[0] = tolower(s[0]);
            s[pos - 1] = tolower(s[pos - 1]);
            for (int i = 1; i < pos - 1; i++) {
                s[i] = '*';
            }
            for (int i = pos; i < s.length(); i++) {
                s[i] = tolower(s[i]);
            }
        } else {
            // phone
            string phone = "";
            for (char c : s) {
                if (isdigit(c)) {
                    phone += c;
                }
            }
            if (phone.length() > 10) {
                phone = "+" + string(phone.length() - 10, '*') + "-" + phone.substr(phone.length() - 10);
            }
            phone = "***-***-" + phone.substr(phone.length() - 4);
            s = phone;
        }
        return s;
    }
};