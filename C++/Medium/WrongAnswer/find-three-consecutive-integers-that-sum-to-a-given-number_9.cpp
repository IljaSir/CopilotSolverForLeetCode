class Solution {
public:
    vector<long long> sumOfThree(long long num) {
        
        for (long long i = 1; i < 1000000; i++) {
            long long a = num - i * (i + 1) * (i + 2) / 6;
            if (a < 0) break;
            if (a % (i * (i + 1) / 2) == 0) {
                long long b = a / (i * (i + 1) / 2);
                if (b > 0) return {b, b + 1, b + 2};
            }
        }
        return {};
    }
};