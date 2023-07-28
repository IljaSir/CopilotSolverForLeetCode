class Solution {
public:
    int arrangeCoins(int n) {
        
        // 1 + 2 + 3 + ... + k <= n
        // 1^2 + 2^2 + 3^2 + ... + k^2 <= n
        // (k^2 + k) / 2 <= n
        // k^2 + k - 2n <= 0
        // k^2 + k - 2n = (k - 1/2)^2 - 1/4
        // k = 1/2 - 1/2 * sqrt(1 + 8n)
        // k = floor(1/2 - 1/2 * sqrt(1 + 8n))
        return (int)floor(0.5 - 0.5 * sqrt(1 + 8.0 * n));
    }
};