class Solution {
public:
    bool areNumbersAscending(string s) {
        
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] >= '0' && s[i] <= '9') {
                int num = 0;
                while (i < s.length() && s[i] >= '0' && s[i] <= '9') {
                    num = num * 10 + s[i] - '0';
                    i++;
                }
                if (num <= prev) {
                    return false;
                }
                prev = num;
            }
        }
        return true;
    }
};