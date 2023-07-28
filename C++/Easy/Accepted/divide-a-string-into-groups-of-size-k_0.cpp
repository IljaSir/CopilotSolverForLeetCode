class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        
        vector<string> res;
        int n = s.size();
        for (int i = 0; i < n; i += k) {
            string t = s.substr(i, k);
            if (t.size() < k) {
                t += string(k - t.size(), fill);
            }
            res.push_back(t);
        }
        return res;
    }
};