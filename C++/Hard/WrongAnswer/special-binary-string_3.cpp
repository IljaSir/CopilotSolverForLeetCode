class Solution {
public:
    string makeLargestSpecial(string s) {
        
        int i = 0;
        vector<string> v;
        for (int j = 0; j < s.size(); ++j) {
            if (s[j] == '1') {
                ++i;
            } else {
                --i;
            }
            if (i == 0) {
                v.push_back('1' + makeLargestSpecial(s.substr(1 + i, j - i - 1)) + '0');
            }
        }
        sort(v.begin(), v.end(), greater<string>());
        string res;
        for (auto &s: v) {
            res += s;
        }
        return res;
    }
};