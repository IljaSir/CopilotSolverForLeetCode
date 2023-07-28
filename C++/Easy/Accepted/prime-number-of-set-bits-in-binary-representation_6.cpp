class Solution {
public:
    int countPrimeSetBits(int left, int right) {
        
        int cnt = 0;
        for (int i = left; i <= right; ++i) {
            int n = i;
            int num = 0;
            while (n) {
                if (n & 1) {
                    num++;
                }
                n >>= 1;
            }
            if (num == 2 || num == 3 || num == 5 || num == 7 || num == 11 || num == 13 || num == 17 || num == 19) {
                cnt++;
            }
        }
        return cnt;
    }
};