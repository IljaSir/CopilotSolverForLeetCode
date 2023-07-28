class Solution {
public:
    string licenseKeyFormatting(string s, int k) {
        
        string res;
        int count = 0;
        for (int i = s.size() - 1; i >= 0; --i) {
            if (s[i] == '-') {
                continue;
            }
            if (s[i] >= 'a' && s[i] <= 'z') {
                res += s[i] - 32;
            } else {
                res += s[i];
            }
            ++count;
            if (count == k) {
                res += '-';
                count = 0;
            }
        }
        if (count == 0) {
            res.pop_back();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};