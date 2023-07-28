class Solution {
public:
    string maskPII(string s) {
        
        if (s.find('@') != string::npos) {
            transform(s.begin(), s.end(), s.begin(), ::tolower);
            int pos = s.find('@');
            s.replace(1, pos - 2, 5, '*');
            return s;
        } else {
            string res;
            for (auto c : s) {
                if (c >= '0' && c <= '9') {
                    res += c;
                }
            }
            string local = "***-***-" + res.substr(res.size() - 4);
            if (res.size() == 10) {
                return local;
            }
            string ans = "+";
            for (int i = 0; i < res.size() - 10; ++i) {
                ans += '*';
            }
            return ans + "-" + local;
        }
    }
};