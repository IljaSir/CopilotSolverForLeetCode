class Solution {
public:
    int rangeSum(vector<int>& nums, int n, int left, int right) {
        
        vector<int> sums;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum = 0;
            for (int j = i; j < n; ++j) {
                sum += nums[j];
                sums.push_back(sum);
            }
        }
        sort(sums.begin(), sums.end());
        int mod = 1000000007;
        sum = 0;
        for (int i = left - 1; i < right; ++i) {
            sum += sums[i];
            sum %= mod;
        }
        return sum;
    }
};