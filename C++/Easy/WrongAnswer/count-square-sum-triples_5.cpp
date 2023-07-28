class Solution {
public:
    int countTriples(int n) {
        
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                int k = i * i + j * j;
                int r = sqrt(k);
                if (r * r == k && r <= n) {
                    res += 2;
                }
            }
        }
        return res;
    }
};