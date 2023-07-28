class Solution {
public:
    string validIPAddress(string queryIP) {
        
        if (queryIP.find(':') != string::npos) {
            // IPv6
            int cnt = 0;
            for (auto c : queryIP) {
                if (c == ':') {
                    cnt++;
                }
            }
            if (cnt != 7) {
                return "Neither";
            }
            istringstream iss(queryIP);
            string token;
            while (getline(iss, token, ':')) {
                if (token.size() > 4 || token.empty()) {
                    return "Neither";
                }
                for (auto c : token) {
                    if (!isdigit(c) && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        } else {
            // IPv4
            int cnt = 0;
            for (auto c : queryIP) {
                if (c == '.') {
                    cnt++;
                }
            }
            if (cnt != 3) {
                return "Neither";
            }
            istringstream iss(queryIP);
            string token;
            while (getline(iss, token, '.')) {
                if (token.size() > 3 || token.empty()) {
                    return "Neither";
                }
                if (token.size() > 1 && token[0] == '0') {
                    return "Neither";
                }
                for (auto c : token) {
                    if (!isdigit(c)) {
                        return "Neither";
                    }
                }
                int num = stoi(token);
                if (num < 0 || num > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
    }
};