class Solution {
public:
    int monotoneIncreasingDigits(int n) {
        
        string s = to_string(n);
        int i = 1;
        while (i < s.length() && s[i-1] <= s[i]) {
            i++;
        }
        if (i < s.length()) {
            while (i > 0 && s[i-1] > s[i]) {
                s[i-1]--;
                i--;
            }
            for (i++; i < s.length(); i++) {
                s[i] = '9';
            }
        }
        return stoi(s);
    }
};