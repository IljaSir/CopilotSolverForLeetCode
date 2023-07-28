class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        
        vector<string> res;
        int n = s.size();
        for (int i = 0; i < n; i += k) {
            string tmp = s.substr(i, k);
            if (tmp.size() < k) {
                tmp += string(k - tmp.size(), fill);
            }
            res.push_back(tmp);
        }
        return res;
    }
};