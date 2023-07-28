class Solution {
public:
    bool checkPowersOfThree(int n) {
        
        int k = 0;
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            if (n % 3 == 1) {
                k++;
            }
            n /= 3;
        }
        return k <= 15;
    }
};