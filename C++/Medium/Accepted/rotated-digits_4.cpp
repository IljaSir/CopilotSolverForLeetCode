class Solution {
public:
    int rotatedDigits(int n) {
        
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) cnt++;
        }
        return cnt;
    }
    bool isGood(int n) {
        bool isGood = false;
        while (n > 0) {
            int r = n % 10;
            if (r == 3 || r == 4 || r == 7) return false;
            if (r == 2 || r == 5 || r == 6 || r == 9) isGood = true;
            n /= 10;
        }
        return isGood;
    }
};