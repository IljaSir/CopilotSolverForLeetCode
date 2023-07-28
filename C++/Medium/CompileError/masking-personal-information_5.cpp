class Solution {
public:
    string maskPII(string s) {
        
        int at = s.find("@");
        if (at != string::npos) {
            string name = s.substr(0, at);
            transform(name.begin(), name.end(), name.begin(), ::tolower);
            string domain = s.substr(at + 1);
            transform(domain.begin(), domain.end(), domain.begin(), ::tolower);
            return name[0] + "*****" + name[name.size() - 1] + "@" + domain;
        }
        else {
            string digits;
            for (char c : s) if (isdigit(c)) digits.push_back(c);
            string local = "***-***-" + digits.substr(digits.size() - 4);
            if (digits.size() == 10) return local;
            string ans = "+";
            for (int i = 0; i < digits.size() - 10; ++i) ans.push_back('*');
            return ans + "-" + local;
        }
    }
};