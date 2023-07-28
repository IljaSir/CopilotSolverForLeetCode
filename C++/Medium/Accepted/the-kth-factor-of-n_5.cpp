class Solution {
public:
    int kthFactor(int n, int k) {
        
        int i = 1;
        int count = 0;
        while (i * i <= n) {
            if (n % i == 0) {
                count++;
                if (count == k) {
                    return i;
                }
            }
            i++;
        }
        i--;
        while (i >= 1) {
            if (i * i == n) {
                i--;
                continue;
            }
            if (n % i == 0) {
                count++;
                if (count == k) {
                    return n / i;
                }
            }
            i--;
        }
        return -1;
    }
};