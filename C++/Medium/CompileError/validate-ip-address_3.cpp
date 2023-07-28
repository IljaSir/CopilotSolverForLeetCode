class Solution {
public:
    string validIPAddress(string queryIP) {
        
        if (queryIP.find(".") != string::npos) {
            return isValidIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.find(":") != string::npos) {
            return isValidIPv6(queryIP) ? "IPv6" : "Neither";
        } else {
            return "Neither";
        }
    }
};