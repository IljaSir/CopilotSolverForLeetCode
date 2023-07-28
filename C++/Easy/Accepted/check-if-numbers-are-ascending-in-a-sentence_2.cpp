class Solution {
public:
    bool areNumbersAscending(string s) {
        
        int n = s.size();
        int i = 0;
        int num = 0;
        int prev = 0;
        while (i < n) {
            if (s[i] >= '0' && s[i] <= '9') {
                num = 0;
                while (i < n && s[i] >= '0' && s[i] <= '9') {
                    num = num * 10 + (s[i] - '0');
                    i++;
                }
                if (num <= prev) {
                    return false;
                }
                prev = num;
            } else {
                i++;
            }
        }
        return true;
    }
};