class Solution {
public:
    long long minCost(vector<int>& nums, vector<int>& cost) {
        
        long long res = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] > nums[i - 1]) continue;
            res += min(cost[i], cost[i - 1]);
            cost[i] = max(cost[i], cost[i - 1]);
            nums[i] = nums[i - 1];
        }
        return res;
    }
};