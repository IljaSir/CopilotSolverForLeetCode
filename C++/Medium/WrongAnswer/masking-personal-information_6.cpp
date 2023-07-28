class Solution {
public:
    string maskPII(string s) {
        
        int at = s.find('@');
        if (at != string::npos) {
            for (auto& c : s) {
                if (c >= 'A' && c <= 'Z') c += ('a' - 'A');
            }
            s[0] = s[0] - 'a' + 'A';
            for (int i = 1; i < at - 1; ++i) {
                s[i] = '*';
            }
            return s;
        }
        string num;
        for (char c : s) {
            if (c >= '0' && c <= '9') num.push_back(c);
        }
        string local = "***-***-" + num.substr(num.size() - 4);
        if (num.size() == 10) {
            return local;
        }
        string ans = "+";
        for (int i = 0; i < num.size() - 10; ++i) {
            ans.push_back('*');
        }
        return ans + "-" + local;
    }
};