class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        long long res = 0;
        int n = nums.size();
        map<int, int> m;
        for (int i = 0; i < k; i++) {
            m[nums[i]]++;
        }
        long long sum = 0;
        for (auto it = m.rbegin(); it != m.rend(); it++) {
            sum += it->first;
        }
        res = sum;
        for (int i = k; i < n; i++) {
            m[nums[i-k]]--;
            if (m[nums[i-k]] == 0) {
                m.erase(nums[i-k]);
            }
            m[nums[i]]++;
            sum = 0;
            for (auto it = m.rbegin(); it != m.rend(); it++) {
                sum += it->first;
            }
            res = max(res, sum);
        }
        return res;
    }
};