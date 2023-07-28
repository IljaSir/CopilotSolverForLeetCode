class Solution {
public:
    string makeLargestSpecial(string s) {
        
        vector<string> v;
        int n = s.length();
        int c = 0;
        int i = 0;
        for (int j = 0; j < n; ++j) {
            if (s[j] == '1') {
                ++c;
            } else {
                --c;
            }
            if (c == 0) {
                v.push_back('1' + makeLargestSpecial(s.substr(i + 1, j - i - 1)) + '0');
                i = j + 1;
            }
        }
        sort(v.begin(), v.end(), greater<string>());
        string r;
        for (auto x: v) {
            r += x;
        }
        return r;
    }
};