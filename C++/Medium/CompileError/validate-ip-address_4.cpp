class Solution {
public:
    string validIPAddress(string queryIP) {
        
        int n = queryIP.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (queryIP[i] == '.') {
                cnt++;
            }
        }
        if (cnt == 3) {
            return checkIPv4(queryIP);
        }
        cnt = 0;
        for (int i = 0; i < n; i++) {
            if (queryIP[i] == ':') {
                cnt++;
            }
        }
        if (cnt == 7) {
            return checkIPv6(queryIP);
        }
        return "Neither";
    }
    string checkIPv4(string queryIP) {
        int n = queryIP.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (queryIP[i] == '.') {
                cnt++;
            }
        }
        if (cnt != 3) {
            return "Neither";
        }
        string ip;
        stringstream ss(queryIP);
        while (getline(ss, ip, '.')) {
            if (ip.size() > 1 && ip[0] == '0') {
                return "Neither";
            }
            int num = 0;
            for (int i = 0; i < ip.size(); i++) {
                if (ip[i] < '0' || ip[i] > '9') {
                    return "Neither";
                }
                num = num * 10 + (ip[i] - '0');
            }
            if (num < 0 || num > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }
    string checkIPv6(string queryIP) {
        int n = queryIP.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (queryIP[i] == ':') {
                cnt++;
            }
        }
        if (cnt != 7) {
            return "Neither";
        }
        string ip;
        stringstream ss(queryIP);
        while (getline(ss, ip, ':')) {
            if (ip.size() > 4) {
                return "Neither";
            }
            for (int i = 0; i < ip.size(); i++) {
                if ((ip[i] >= '0' && ip[i] <=
    }
};