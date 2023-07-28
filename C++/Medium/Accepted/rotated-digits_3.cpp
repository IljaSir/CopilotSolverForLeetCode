class Solution {
public:
    int rotatedDigits(int n) {
        
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                cnt++;
            }
        }
        return cnt;
    }
    bool isGood(int n) {
        bool flag = false;
        while (n) {
            int r = n % 10;
            if (r == 3 || r == 4 || r == 7) {
                return false;
            }
            if (r == 2 || r == 5 || r == 6 || r == 9) {
                flag = true;
            }
            n /= 10;
        }
        return flag;
    }
};