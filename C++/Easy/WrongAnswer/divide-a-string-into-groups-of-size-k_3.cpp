class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        
        int n = s.size();
        int m = n / k;
        vector<string> res;
        for (int i = 0; i < m; i++) {
            res.push_back(s.substr(i * k, k));
        }
        string last = s.substr(m * k);
        if (last.size() < k) {
            for (int i = 0; i < k - last.size(); i++) {
                last.push_back(fill);
            }
        }
        res.push_back(last);
        return res;
    }
};