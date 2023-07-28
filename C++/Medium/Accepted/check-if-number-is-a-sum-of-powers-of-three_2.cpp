class Solution {
public:
    bool checkPowersOfThree(int n) {
        
        int i = 0;
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
            i++;
        }
        return true;
    }
};