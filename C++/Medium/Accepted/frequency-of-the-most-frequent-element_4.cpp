class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int res = 1;
        long long total = 0;
        int j = 0;
        for (int i = 1; i < nums.size(); i++) {
            total += (long long)(nums[i] - nums[i - 1]) * (i - j);
            while (total > k) {
                total -= nums[i] - nums[j];
                j++;
            }
            res = max(res, i - j + 1);
        }
        return res;
    }
};