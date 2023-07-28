class Solution {
public:
    int findKthNumber(int n, int k) {
        
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            long long steps = getStep(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }
    long long getStep(int n, long long n1, long long n2) {
        long long step = 0;
        while (n1 <= n) {
            step += min((long long)n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return step;
    }
};