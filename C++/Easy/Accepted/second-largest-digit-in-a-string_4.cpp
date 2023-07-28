class Solution {
public:
    int secondHighest(string s) {
        
        int max = -1;
        int sec = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] >= '0' && s[i] <= '9') {
                int dig = s[i] - '0';
                if (dig > max) {
                    sec = max;
                    max = dig;
                } else if (dig > sec && dig != max) {
                    sec = dig;
                }
            }
        }
        return sec;
    }
};