class Solution {
public:
    int countTriples(int n) {
        
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c = a * a + b * b;
                if (c > n * n) break;
                int s = sqrt(c);
                if (s * s == c) count++;
            }
        }
        return count;
    }
};