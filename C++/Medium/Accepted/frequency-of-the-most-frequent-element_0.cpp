class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int i = 0;
        long long sum = 0;
        int res = 1;
        for (int j = 1; j < n; ++j) {
            sum += (long long)(nums[j] - nums[j - 1]) * (j - i);
            while (sum > k) {
                sum -= nums[j] - nums[i];
                ++i;
            }
            res = max(res, j - i + 1);
        }
        return res;
    }
};