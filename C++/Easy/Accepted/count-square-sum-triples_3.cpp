class Solution {
public:
    int countTriples(int n) {
        
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                int c = sqrt(a * a + b * b);
                if (c <= n && c * c == a * a + b * b) {
                    count += 2;
                }
            }
        }
        return count;
    }
};