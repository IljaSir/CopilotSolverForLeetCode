class Solution {
public:
    int countEven(int num) {
        
        int res = 0;
        while (num) {
            res += num % 2;
            num /= 2;
        }
        return res;
    }
};