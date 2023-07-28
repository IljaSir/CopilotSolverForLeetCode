class Solution {
public:
    string validIPAddress(string queryIP) {
        
        if (queryIP.find('.') != string::npos) {
            return validIPv4(queryIP) ? "IPv4" : "Neither";
        }
        if (queryIP.find(':') != string::npos) {
            return validIPv6(queryIP) ? "IPv6" : "Neither";
        }
        return "Neither";
    }
    
    bool validIPv4(string IP) {
        if (count(IP.begin(), IP.end(), '.') != 3) {
            return false;
        }
        vector<string> nums = split(IP, '.');
        if (nums.size() != 4) {
            return false;
        }
        for (string num : nums) {
            if (num.empty() || num.size() > 3) {
                return false;
            }
            if (num.size() > 1 && num[0] == '0') {
                return false;
            }
            for (char c : num) {
                if (!isdigit(c)) {
                    return false;
                }
            }
            int n = stoi(num);
            if (n < 0 || n > 255) {
                return false;
            }
        }
        return true;
    }
    
    bool validIPv6(string IP) {
        if (count(IP.begin(), IP.end(), ':') != 7) {
            return false;
        }
        vector<string> nums = split(IP, ':');
        if (nums.size() != 8) {
            return false;
        }
        for (string num : nums) {
            if (num.empty() || num.size() > 4) {
                return false;
            }
            for (char c : num) {
                if (!(isdigit(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    vector<string> split(string s, char delim) {
        vector<string> res;
        stringstream ss(s);
        string token;
        while (getline(ss, token, delim)) {
            res.push_back(token);
        }
        return res;
    }
};