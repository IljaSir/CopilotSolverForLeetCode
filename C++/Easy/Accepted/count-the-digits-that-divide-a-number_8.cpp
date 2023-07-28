class Solution {
public:
    int countDigits(int num) {
        
        int res = 0;
        for (char c : to_string(num)) {
            int d = c - '0';
            if (d != 0 && num % d == 0) {
                ++res;
            }
        }
        return res;
    }
};