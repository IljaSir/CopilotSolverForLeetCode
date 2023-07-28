class Solution {
public:
    string maskPII(string s) {
        
        if (s.find('@') != string::npos) {
            transform(s.begin(), s.end(), s.begin(), ::tolower);
            int pos = s.find('@');
            s[0] = '*';
            s[pos - 1] = '*';
            for (int i = 1; i < pos - 1; ++i) {
                s[i] = '*';
            }
        } else {
            string res;
            for (char c : s) {
                if (isdigit(c)) {
                    res.push_back(c);
                }
            }
            if (res.size() == 10) {
                res = "***-***-" + res.substr(res.size() - 4);
            } else {
                res = "+";
                for (int i = 0; i < res.size() - 10; ++i) {
                    res.push_back('*');
                }
                res += "-***-***-" + res.substr(res.size() - 4);
            }
        }
        return s;
    }
};