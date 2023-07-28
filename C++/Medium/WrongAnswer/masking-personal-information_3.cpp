class Solution {
public:
    string maskPII(string s) {
        
        int at = s.find('@');
        if (at != string::npos) {
            // email
            transform(s.begin(), s.end(), s.begin(), ::tolower);
            s[0] = '*';
            s[at-1] = '*';
            s[at-2] = '*';
            s[at-3] = '*';
            s[at-4] = '*';
            return s;
        } else {
            // phone
            string phone;
            for (char c: s) {
                if (c >= '0' && c <= '9') {
                    phone += c;
                }
            }
            if (phone.length() == 10) {
                return "***-***-" + phone.substr(phone.length()-4);
            } else {
                return "+" + string(phone.length()-10, '*') + "-***-***-" + phone.substr(phone.length()-4);
            }
        }
    }
};