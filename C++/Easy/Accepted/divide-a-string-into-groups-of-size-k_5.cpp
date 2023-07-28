class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        
        int n = s.size();
        int m = (n + k - 1) / k;
        vector<string> res(m);
        int i = 0;
        for (int j = 0; j < m; ++j) {
            res[j] = s.substr(i, k);
            if (res[j].size() < k) {
                res[j].append(k - res[j].size(), fill);
            }
            i += k;
        }
        return res;
    }
};