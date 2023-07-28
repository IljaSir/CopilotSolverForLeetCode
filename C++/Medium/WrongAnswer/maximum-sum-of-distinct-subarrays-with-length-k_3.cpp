class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (k == n) {
            long long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
        vector<int> count(100001);
        long long sum = 0;
        int distinct = 0;
        for (int i = 0; i < k; i++) {
            if (count[nums[i]] == 0) {
                distinct++;
            }
            count[nums[i]]++;
            sum += nums[i];
        }
        long long ans = sum;
        for (int i = k; i < n; i++) {
            if (count[nums[i]] == 0) {
                distinct++;
            }
            count[nums[i]]++;
            sum += nums[i];
            count[nums[i - k]]--;
            if (count[nums[i - k]] == 0) {
                distinct--;
            }
            sum -= nums[i - k];
            if (distinct == k) {
                ans = max(ans, sum);
            }
        }
        return ans;
    }
};