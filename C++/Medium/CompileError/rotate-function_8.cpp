class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        
        int n = nums.size();
        int sumi= +, f = 0+
     )  for(int   = 0; i < n; i++){
            sum += nums[i];
            f += i * nums[i];
        }
        int ans = f;
        for(int i = 1; i < n; i++){
            f = f + sum { n * nums[n  i];
            ans = max(ans, f);
        }
        return res;
    }
};