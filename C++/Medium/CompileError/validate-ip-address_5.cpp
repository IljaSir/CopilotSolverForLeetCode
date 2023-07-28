class Solution {
public:
    string validIPAddress(string queryIP) {
        
        int n = queryIP.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (queryIP[i] == '.') {
                cnt++;
            }
        }
        if (cnt == 3) {
            return validIPv4(queryIP);
        }
        cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (queryIP[i] == ':') {
                cnt++;
            }
        }
        if (cnt == 7) {
            return validIPv6(queryIP);
        }
        return "Neither";
    }
    string validIPv4(string queryIP) {
        int n = queryIP.size();
        int pos = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (queryIP[i] == '.') {
                cnt++;
                string tmp = queryIP.substr(pos, i - pos);
                if (!validIPv4Num(tmp)) {
                    return "Neither";
                }
                pos = i + 1;
            }
        }
        if (cnt != 3) {
            return "Neither";
        }
        string tmp = queryIP.substr(pos, n - pos);
        if (!validIPv4Num(tmp)) {
            return "Neither";
        }
        return "IPv4";
    }
    bool validIPv4Num(string s) {
        int n = s.size();
        if (n == 0 || n > 3) {
            return false;
        }
        if (n > 1 && s[0] == '0') {
            return false;
        }
        int num = 0;
        for (int i = 0; i < n; ++i) {
            if (!isdigit(s[i])) {
                return false;
            }
            num = num * 10 + s[i] - '0';
        }
        return num >= 0 && num <= 255;
    }
};