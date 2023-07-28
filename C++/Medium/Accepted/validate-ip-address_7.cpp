class Solution {
public:
    string validIPAddress(string queryIP) {
        
        if (queryIP.find(".") != std::string::npos) {
            if (queryIP.back() == '.') return "Neither";
            std::istringstream iss(queryIP);
            std::string token;
            int cnt = 0;
            while (std::getline(iss, token, '.')) {
                if (token.empty() || token.size() > 3) return "Neither";
                if (token.size() > 1 && token[0] == '0') return "Neither";
                for (auto c: token) {
                    if (!isdigit(c)) return "Neither";
                }
                int n = std::stoi(token);
                if (n < 0 || n > 255) return "Neither";
                ++cnt;
            }
            return cnt == 4? "IPv4": "Neither";
        } else if (queryIP.find(":") != std::string::npos) {
            if (queryIP.back() == ':') return "Neither";
            std::istringstream iss(queryIP);
            std::string token;
            int cnt = 0;
            while (std::getline(iss, token, ':')) {
                if (token.empty() || token.size() > 4) return "Neither";
                for (auto c: token) {
                    if (!isdigit(c) && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) return "Neither";
                }
                ++cnt;
            }
            return cnt == 8? "IPv6": "Neither";
        } else {
            return "Neither";
        }
    }
};