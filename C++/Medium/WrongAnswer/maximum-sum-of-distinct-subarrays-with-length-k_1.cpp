class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        long long sum = 0;
        int n = nums.size();
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        long long maxSum = sum;
        set<int> s(nums.begin(), nums.begin() + k);
        for (int i = k; i < n; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            if (s.find(nums[i]) == s.end()) {
                maxSum = max(maxSum, sum);
                s.erase(nums[i - k]);
                s.insert(nums[i]);
            }
        }
        return maxSum;
    }
};