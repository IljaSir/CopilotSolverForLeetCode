class Solution {
public:
    int countSpecialNumbers(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            int digit[10] = {0};
            while (num > 0) {
                int d = num % 10;
                if (digit[d] == 1) {
                    break;
                }
                digit[d] = 1;
                num /= 10;
            }
            if (num == 0) {
                count++;
            }
        }
        return count;
    }
};