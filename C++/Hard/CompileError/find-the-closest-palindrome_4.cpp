class Solution {
public:
    string nearestPalindromic(string n) {
        
        int len = n.size();
        string res;
        vector<long> candidates{long(pow(10, len)) + 1, long(pow(10, len - 1)) - 1};
        long prefix = stol(n.substr(0, (len + 1) / 2));
        for (int i = -1; i <= 1; ++i) {
            string p = to_string(prefix + i);
            string cur = p + string(p.rbegin() + (len & 1), p.rend());
            candidates.push_back(stol(cur));
        }
        long num = stol(n), diff = LONG_MAX;
        for (long cand : candidates) {
            if (cand == num) continue;
            if (abs(cand - num) < diff || (abs(cand - num) == diff && cand < res)) {
                diff = abs(cand - num);
                res = to_string(cand);
            }
        }
        return res;
    }
};