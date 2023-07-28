class Solution {
public:
    int minElements(vector<int>& nums, int limit, int goal) {
        
        long long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        long long delta = abs(goal - sum);
        return (delta + limit - 1) / limit;
    }
};