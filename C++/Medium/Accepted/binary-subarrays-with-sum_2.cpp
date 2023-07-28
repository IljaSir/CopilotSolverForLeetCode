class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        
        int n = nums.size();
        vector<int> prefix(n+1, 0);
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        unordered_map<int, int> count;
        int res = 0;
        for (int i = 0; i <= n; ++i) {
            res += count[prefix[i] - goal];
            ++count[prefix[i]];
        }
        return res;
    }
};