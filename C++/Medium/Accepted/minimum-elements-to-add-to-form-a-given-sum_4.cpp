class Solution {
public:
    int minElements(vector<int>& nums, int limit, int goal) {
        
        long sum = 0;
        for (auto n : nums) {
            sum += n;
        }
        long diff = abs(goal - sum);
        return (diff + limit - 1) / limit;
    }
};