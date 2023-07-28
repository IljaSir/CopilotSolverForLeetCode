class Solution {
public:
    int findKthNumber(int n, int k) {
        
        int cur = 1;
        k = k - 1;
        while (k > 0) {
            long long steps = 0, first = cur, last = cur + 1;
            while (first <= n) {
                steps += min((long long)n + 1, last) - first;
                first *= 10;
                last *= 10;
            }
            if (steps <= k) {
                cur += 1;
                k -= steps;
            } else {
                cur *= 10;
                k -= 1;
            }
        }
        return cur;
    }
};