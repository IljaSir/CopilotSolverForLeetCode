class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        int F = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            F += i * nums[i];
        }
        int maxF = F;
        for (int i = 1; i < n; ++i) {
            F = F + sum - n * nums[n - i];
            maxF = max(maxF, F);
        }
        return maxF;
    }
};