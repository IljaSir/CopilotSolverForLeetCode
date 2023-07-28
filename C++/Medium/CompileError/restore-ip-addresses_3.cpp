class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        
        vector<string> result;
        if (s.size() < 4) {
            return result;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k < j + 4; k++) {
                    if (k >= s.size()) {
                        break;
                    }
                    string s1 = s.substr(0, i);
                    string s2 = s.substr(i, j - i);
                    string s3 = s.substr(j, k - j);
                    string s4 = s.substr(k);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.push_back(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return result;
    }
};