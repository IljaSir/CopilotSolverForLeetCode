class Solution {
public:
    string removeKdigits(string num, int k) {
        
        if (num.length() == k) return "0";
        string res;
        int n = num.length();
        int i = 0;
        while (k > 0) {
            if (i == res.length()) {
                res.push_back(num[i]);
                i++;
            } else {
                if (num[i] >= res.back()) {
                    res.push_back(num[i]);
                    i++;
                } else {
                    res.pop_back();
                    k--;
                }
            }
        }
        res += num.substr(i);
        while (res.length() > 1 && res[0] == '0') res.erase(res.begin());
        return res.substr(0, res.length() - k);
    }
};