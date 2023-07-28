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
    bool validIPv4(string queryIP) {
        if (count(queryIP.begin(), queryIP.end(), '.') != 3) {
            return false;
        }
        for (int i = 0; i < queryIP.size(); ++i) {
            if (queryIP[i] == '.') {
                if (i == 0 || i == queryIP.size() - 1) {
                    return false;
                }
                string temp = queryIP.substr(0, i);
                queryIP = queryIP.substr(i + 1);
                i = -1;
                if (temp.size() > 3 || temp.size() == 0) {
                    return false;
                }
                for (int j = 0; j < temp.size(); ++j) {
                    if (!isdigit(temp[j])) {
                        return false;
                    }
                }
                if (temp.size() > 1 && temp[0] == '0') {
                    return false;
                }
                int x = stoi(temp);
                if (x < 0 || x > 255) {
                    return false;
                }
            }
        }
        if (queryIP.size() > 3 || queryIP.size() == 0) {
            return false;
        }
        for (int j = 0; j < queryIP.size(); ++j) {
            if (!isdigit(queryIP[j])) {
                return false;
            }
        }
        if (queryIP.size() > 1 && queryIP[0] == '0') {
            return false;
        }
        int x = stoi(queryIP);
        if (x < 0 || x > 255) {
            return false;
        }
        return true;
    }
    bool validIPv6(string queryIP) {
        if (count(queryIP.begin(), queryIP.end(), ':') != 7) {
            return false;
        }
        for (int i = 0; i < queryIP.size(); ++i) {
            if (queryIP[i] == ':') {
                if (
    }
};