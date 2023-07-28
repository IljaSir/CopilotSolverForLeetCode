class Solution {
public:
    int countSpecialNumbers(int n) {
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            int bit[10] = {0};
            while (num > 0) {
                int d = num % 10;
                if (bit[d] == 1) {
                    break;
                }
                bit[d] = 1;
                num /= 10;
            }
            if (num == 0) {
                ans++;
            }
        }
        return ans;
    }
};