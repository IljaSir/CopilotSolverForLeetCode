class Solution {
public:
    int sumOfFlooredPairs(vector<int>& nums) {
        
        int mod = 1e9+7;
        int max = 0;
        for (auto n : nums) {
            if (n > max) max = n;
        }
        vector<int> count(max+1, 0);
        for (auto n : nums) {
            ++count[n];
        }
        int sum = 0;
        for (int i = 1; i <= max; ++i) {
            int total = 0;
            for (int j = i; j <= max; j += i) {
                total += count[j];
                sum = (sum + (long long)total * (j / i) % mod) % mod;
            }
        }
        return sum;
    }
};