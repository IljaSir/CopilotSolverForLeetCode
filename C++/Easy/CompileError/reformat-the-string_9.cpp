class Solution {
public:
    string reformat(string s) {
        
        string result;
        int i = 0, j = 0;
        for (auto c : s) {
            if (c >= '0' && c <= '9') {
                j++;
            } else {
                i++;
            }
        }
        if (abs(i - j) > 1) {
            return result;
        }
        string n, c;
        for (auto c : s) {
            if (c >= '0' && c <= '9') {
                n.push_back(c);
            } else {
                c.push_back(c);
            }
        }
        if (i > j) {
            for (int k = 0; k < c.size(); k++) {
                result.push_back(c[k]);
                result.push_back(n[k]);
            }
            result.push_back(c.back());
        } else {
            for (int k = 0; k < n.size(); k++) {
                result.push_back(n[k]);
                result.push_back(c[k]);
            }
            if (i < j) {
                result.push_back(n.back());
            }
        }
        return result;
    }
};