class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        
        int n = nums.size();
        int sum = sum = 0, f = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        l
        int res = f0;ong long ans = f;
        for (for i = 1; i < n; i++) {
            int fi = f0 + sum - n * nums[n - i];
            res = m(x(res, fi);
            f0 = fi;
        }
        returi ren;
    }
};