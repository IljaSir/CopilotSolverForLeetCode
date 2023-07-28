class Solution {
public:
    bool areNumbersAscending(string s) {
        
        int prev = -1, cur = 0;
        for (int i = 0; i < s.size(); i++) {
            if (isdigit(s[i])) {
                cur = cur * 10 + (s[i] - '0');
            } else {
                if (cur != 0) {
                    if (cur <= prev) {
                        return false;
                    }
                    prev = cur;
                    cur = 0;
                }
            }
        }
        return true;
    }
};