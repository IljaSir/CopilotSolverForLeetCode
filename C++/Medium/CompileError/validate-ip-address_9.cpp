class Solution {
public:
    string validIPAddress(string queryIP) {
        
        if (queryIP.find('.') != string::npos) {
            if (queryIP.find(':') != string::npos) return "Neither";
            int cnt = 0, num = 0;
            for (int i = 0; i < queryIP.size(); i++) {
                if (queryIP[i] == '.') {
                    cnt++;
                    if (cnt > 3 || num < 0 || num > 255 || (queryIP[i-1] == '0' && i-1 >= 0 && queryIP[i-2] != '.')) return "Neither";
                    num = 0;
                } else if (queryIP[i] >= '0' && queryIP[i] <= '9') {
                    num = num * 10 + (queryIP[i] - '0');
                } else {
                    return "Neither";
                }
            }
            if (cnt != 3 || num < 0 || num > 255 || (queryIP[queryIP.size()-1] == '0' && queryIP[queryIP.size()-2] != '.')) return "Neither";
            return "IPv4";
        } else if (queryIP.find(':') != string::npos) {
            if (queryIP.find('.') != string::npos) return "Neither";
            int cnt = 0, num = 0;
            for (int i = 0; i < queryIP.size(); i++) {
                if (queryIP[i] == ':') {
                    cnt++;
                    if (cnt > 7 || num < 0 || num > 65535 || (queryIP[i-1] == '0' && i-1 >= 0 && queryIP[i-2] != ':')) return "Neither";
                    num = 0;
                } else if ((queryIP[i] >= '0' && queryIP[i] <= '9') || (queryIP[i] >= 'a' && queryIP[i] <= 'f') || (queryIP[i] >= 'A' && queryIP[i] <= 'F')) {
                    if (queryIP[i] >= '0' && queryIP[i] <= '9') num = num * 16 + (queryIP[i] - '0');
                    else if (queryIP[i] >= 'a' && queryIP[i] <= 'f') num = num * 16 + (queryIP[i
    }
};