class Solution {
public:
    bool isThree(int n) {
        
        int cnt = 0;
        for (int i = 1; i * i <= n; ++i) {
            if (n % i == 0) {
                cnt += 1;
                if (i * i != n) cnt += 1;
            }
            if (cnt > 3) return false;
        }
        return cnt == 3;
    }
};