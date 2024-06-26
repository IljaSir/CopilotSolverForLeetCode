class Solution {
public:
    int minElements(vector<int>& nums, int limit, int goal) {
        
        long long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long long diff = abs(sum - goal);
        return (diff + limit - 1) / limit;
    }
};