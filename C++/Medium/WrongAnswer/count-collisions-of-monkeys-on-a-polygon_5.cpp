class Solution {
public:
    int monkeyMove(int n) {
        
        long long res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res * 2) % 1000000007;
        }
        return res;
    }

    int countCollisions(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = (res + monkeyMove(i)) % 1000000007;
        }
        return res;
    }
};