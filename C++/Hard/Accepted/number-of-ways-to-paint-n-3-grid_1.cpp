class Solution {
public:
    int numOfWays(int n) {
        
        constexpr int kMod = 1e9 + 7;
        long long a121 = 6, a123 = 6;
        for (int i = 1; i < n; ++i) {
            long long b121 = (3 * a121 + 2 * a123) % kMod;
            long long b123 = (2 * a121 + 2 * a123) % kMod;
            a121 = b121;
            a123 = b123;
        }
        return (a121 + a123) % kMod;
    }
};