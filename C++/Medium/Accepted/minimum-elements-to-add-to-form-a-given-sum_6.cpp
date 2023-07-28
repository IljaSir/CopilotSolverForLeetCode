class Solution {
public:
    int minElements(vector<int>& nums, int limit, int goal) {
        
        long long sum = 0;
        for (int num : nums) sum += num;
        sum = goal - sum;
        if (sum == 0) return 0;
        if (sum < 0) sum = -sum;
        return (sum + limit - 1) / limit;
    }
};