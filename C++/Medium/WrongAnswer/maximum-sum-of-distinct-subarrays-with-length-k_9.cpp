class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        const int N = nums.size();
        unordered_map<int, int> count;
        int distinct = 0;
        long long sum = 0;
        long long res = 0;
        for (int i = 0; i < N; ++i) {
            if (count[nums[i]]++ == 0) ++distinct;
            if (i >= k && --count[nums[i - k]] == 0) --distinct;
            if (distinct == k) res = max(res, sum += nums[i]);
            else if (distinct < k) sum += nums[i];
            else sum = nums[i], distinct = 1;
        }
        return res;
    }
};