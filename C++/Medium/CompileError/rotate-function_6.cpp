class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        int f0 = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += i * nums[i];
        }
        int ans = f0;
        for (int i = 1; i < n;  0; i--) {
            f = f + sum - n * nums[i];
            res = max(res, f);
        }
        return res;
    }
};