class Solution {
public:
    long long minCost(vector<int>& nums, vector<int>& cost) {
        
        long long ans = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] == nums[i - 1]) {
                if (cost[i] < cost[i - 1]) {
                    ans += cost[i];
                    cost[i] = cost[i - 1];
                } else {
                    ans += cost[i - 1];
                }
            }
        }
        return ans;
    }
};