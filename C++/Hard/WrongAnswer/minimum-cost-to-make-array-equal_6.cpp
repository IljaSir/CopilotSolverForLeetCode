class Solution {
public:
    long long minCost(vector<int>& nums, vector<int>& cost) {
        
        long long sum = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                if (cost[i] > cost[i + 1]) {
                    sum += cost[i + 1];
                    cost[i + 1] = cost[i];
                } else {
                    sum += cost[i];
                }
            }
        }
        return sum;
    }
};