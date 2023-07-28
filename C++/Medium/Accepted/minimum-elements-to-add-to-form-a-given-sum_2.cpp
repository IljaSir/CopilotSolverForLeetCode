class Solution {
public:
    int minElements(vector<int>& nums, int limit, int goal) {
        
        long long sum = 0;
        for (int n : nums) sum += n;
        long long diff = abs(goal - sum);
        return (diff + limit - 1) / limit;
    }
};