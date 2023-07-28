class Solution {
public:
    int monotoneIncreasingDigits(int n) {
        
        string s = to_string(n);
        int i = 1;
        while (i < s.size() && s[i - 1] <= s[i]) {
            i++;
        }
        if (i < s.size()) {
            while (i > 0 && s[i - 1] > s[i]) {
                s[i - 1]--;
                i--;
            }
            for (i++; i < s.size(); i++) {
                s[i] = '9';
            }
        }
        return stoi(s);
    }
};