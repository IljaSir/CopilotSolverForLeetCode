class Solution {
public:
    string maskPII(string s) {
        
        if (s.find('@') != string::npos) {
            // Email
            transform(s.begin(), s.end(), s.begin(), ::tolower);
            s[0] = '*';
            s[s.find('@') - 1] = '*';
            s[s.find('@') - 2] = '*';
            s[s.find('@') - 3] = '*';
            s[s.find('@') - 4] = '*';
        } else {
            // Phone
            string digits;
            for (char c : s) {
                if (isdigit(c)) {
                    digits += c;
                }
            }
            if (digits.size() == 10) {
                s = "***-***-" + digits.substr(6);
            } else {
                s = "+";
                for (int i = 0; i < digits.size() - 10; ++i) {
                    s += '*';
                }
                s += "-***-***-" + digits.substr(digits.size() - 4);
            }
        }
        return s;
    }
};