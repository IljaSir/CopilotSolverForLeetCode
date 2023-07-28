class Solution {
public:
    string validIPAddress(string queryIP) {
        
        if (queryIP.find('.') != string::npos) {
            return validIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.find(':') != string::npos) {
            return validIPv6(queryIP) ? "IPv6" : "Neither";
        } else {
            return "Neither";
        }
    }
};