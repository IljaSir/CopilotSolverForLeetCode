class Solution {
public:
    long long minCost(vector<int>& nums, vector<int>& cost) {
        
        long long res = 0;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] == nums[i - 1]) {
                if (cost[i] < cost[i - 1]) {
                    res += cost[i];
                    cost[i] = cost[i - 1];
                } else {
                    res += cost[i - 1];
                }
            }
        }
        return res;
    }
};