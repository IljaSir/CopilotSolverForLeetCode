class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        long long res = 0;
        int n = nums.size();
        unordered_map<int, int> m;
        int i = 0;
        long long sum = 0;
        for (int j = 0; j < n; ++j) {
            if (m[nums[j]]++ == 0) sum += nums[j];
            if (j - i + 1 > k) {
                if (--m[nums[i++]] == 0) sum -= nums[i - 1];
            }
            if (j - i + 1 == k) res = max(res, sum);
        }
        return res;
    }
};