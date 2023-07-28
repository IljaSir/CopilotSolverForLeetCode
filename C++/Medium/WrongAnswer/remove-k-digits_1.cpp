class Solution {
public:
    string removeKdigits(string num, int k) {
        
        int n = num.size();
        string res;
        for (int i = 0; i < n; ++i) {
            while (k > 0 && !res.empty() && res.back() > num[i]) {
                res.pop_back();
                --k;
            }
            res.push_back(num[i]);
        }
        res.resize(n - k);
        int s = 0;
        while (s < res.size() && res[s] == '0') {
            ++s;
        }
        if (s == res.size()) {
            return "0";
        }
        return res.substr(s);
    }
};