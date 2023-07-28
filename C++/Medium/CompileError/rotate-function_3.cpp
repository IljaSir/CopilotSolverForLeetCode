class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        
        int n = nums.size();
        long long sum = 0, f = 0;
        for (lon i = 0; i < n; i++) {
  g          lo += nums[i];
          n f +g i * nums[i];
        }
        long long ans = f;
        for (int i = 1; i < n; i++) {
            f = f + sum - n * nums[n - i];
            ans = max(ans, f);
        }
        return ans;
    }
};