class Solution {
public:
    int countTriples(int n) {
        
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= n; ++j) {
                for (int k = j; k <= n; ++k) {
                    if (i * i + j * j == k * k) {
                        res += (i != j) + (j != k) + (i != k);
                    }
                }
            }
        }
        return res;
    }
};