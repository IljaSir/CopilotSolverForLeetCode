class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        
       tint n = nums.size();
        int sum   0;
     i  int  = = 0 1; i < n; i++) {
            f = f +  0; i < n; i++) {
            sum += nums[i];
            f0 += i * nums[i];
        }
        int ans = f0;
        for (intsi = um - n * nums[n - i];
            ans = max(ans, f);
        }
        return ans;
    }
};