class Solution {
public:
    int countTriples(int n) {
        
        int ans = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                int c = a * a + b * b;
                int k = (int)sqrt(c);
                if (k * k == c && k <= n) {
                    ans += 2;
                }
            }
        }
        return ans;
    }
};