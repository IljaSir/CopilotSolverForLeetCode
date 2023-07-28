class Solution {
public:
    int monotoneIncreasingDigits(int n) {
        
        if (n < 10) return n;
        string s = to_string(n);
        int i = 1;
        while (i < s.size() && s[i] >= s[i - 1]) ++i;
        while (i > 0 && i < s.size() && s[i] < s[i - 1]) {
            --s[i - 1];
            --i;
        }
        for (int j = i + 1; j < s.size(); ++j) s[j] = '9';
        return stoi(s);
    }
};