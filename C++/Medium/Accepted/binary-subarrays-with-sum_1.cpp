class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        
        int n = nums.size();
        vector<int> preSum(n+1, 0);
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        unordered_map<int, int> cnt;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += cnt[preSum[i]-goal];
            cnt[preSum[i]]++;
        }
        return res;
    }
};