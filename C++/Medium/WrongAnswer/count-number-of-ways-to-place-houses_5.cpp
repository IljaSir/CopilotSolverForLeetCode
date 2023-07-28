class Solution {
public:
    int countHousePlacements(int n) {
        
        long long a = 1, b = 1, c = 1;
        for (int i = 1; i <= n; ++i) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
};