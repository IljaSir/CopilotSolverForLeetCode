class Solution {
public:
    int passThePillow(int n, int time) {
        
        int result = 0;
        if (n % 2 == 0) {
            result = time % n;
            if (result == 0) {
                result = n;
            }
        } else {
            result = (time % (2 * n - 2));
            if (result == 0) {
                result = n;
            } else if (result > n) {
                result = 2 * n - result;
            }
        }
        return result;
    }
};