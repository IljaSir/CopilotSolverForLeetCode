class Solution {
public:
    int minElements(vector<int>& nums, int limit, int goal) {
        
        long long sum = accumulate(nums.begin(), nums.end(), 0LL);
        long long d = abs(sum - goal);
        return (d + limit - 1) / limit;
    }
};