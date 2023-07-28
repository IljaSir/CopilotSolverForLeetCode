class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        long long res = 0;
        int n = nums.size();
        unordered_map<int, int> m;
        for (int i = 0; i < k; ++i) {
            m[nums[i]]++;
            res += nums[i];
        }
        long long ans = res;
        for (int i = k; i < n; ++i) {
            res += nums[i] - nums[i - k];
            m[nums[i]]++;
            m[nums[i - k]]--;
            if (m[nums[i - k]] == 0) {
                m.erase(nums[i - k]);
            }
            if (m.size() == k) {
                ans = max(ans, res);
            }
        }
        return ans;
    }
};