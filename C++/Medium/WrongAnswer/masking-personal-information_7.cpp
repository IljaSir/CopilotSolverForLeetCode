class Solution {
public:
    string maskPII(string s) {
        
        int n = s.size();
        int at = s.find('@');
        if (at != string::npos) {
            for (int i = 1; i < n - 1; i++) {
                if (s[i] >= 'A' && s[i] <= 'Z') {
                    s[i] += 32;
                }
            }
            s[0] += 32;
            for (int i = 1; i < n - 1; i++) {
                if (s[i] != '@' && s[i] != '.') {
                    s[i] = '*';
                }
            }
            return s;
        }
        int i = 0;
        string res;
        while (i < n) {
            if (s[i] >= '0' && s[i] <= '9') {
                res.push_back(s[i]);
            }
            i++;
        }
        int m = res.size();
        if (m == 10) {
            res = "***-***-" + res.substr(m - 4, 4);
        }
        else {
            res = "+";
            for (int i = 0; i < m - 10; i++) {
                res.push_back('*');
            }
            res += "-***-***-" + res.substr(m - 4, 4);
        }
        return res;
    }
};