class Solution {
public:
    long long minCost(vector<int>& nums, vector<int>& cost) {
        
        long long ans = 0;
        int n = nums.size();
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1]) {
                ans += min(cost[i], cost[i-1]);
                if (cost[i] < cost[i-1]) {
                    nums[i] = nums[i-1] + 1;
                } else {
                    nums[i-1] = nums[i] + 1;
                }
            }
        }
        return ans;
    }
};