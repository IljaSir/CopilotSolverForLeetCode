class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        
        long sum = 0, f = 0, n = nums.size();
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        long res = f;
        for (int i = n - 1; i > 0; i--) {
            f = f + sum - n * nums[i];
            res = max(res, f);
        }
        return res;
    }
};