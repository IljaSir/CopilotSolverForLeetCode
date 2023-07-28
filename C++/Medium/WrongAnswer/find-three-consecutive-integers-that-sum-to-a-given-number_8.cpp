class Solution {
public:
    vector<long long> sumOfThree(long long num) {
        
        for (long long i = 0; i < num; ++i) {
            long long sum = i * (i + 1) / 2;
            if (sum > num) break;
            long long a = num - sum;
            if (a % (i + 1) == 0) {
                long long b = a / (i + 1);
                return {b, b + 1, b + i + 1};
            }
        }
        return {};
    }
};