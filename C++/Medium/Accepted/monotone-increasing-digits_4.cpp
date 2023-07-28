class Solution {
public:
    int monotoneIncreasingDigits(int n) {
        
        string s = to_string(n);
        int i = 1;
        while (i < s.size() && s[i - 1] <= s[i]) ++i;
        while (i > 0 && i < s.size() && s[i - 1] > s[i]) {
            --s[i - 1];
            --i;
        }
        for (i += 1; i < s.size(); ++i) s[i] = '9';
        return stoi(s);
    }
};