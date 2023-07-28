class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        
        int n = nums.size();
        int odd = 0, even = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even += nums[i];
            } else {
                odd += nums[i];
            }
        }
        int res = 0;
        int odd_ = 0, even_ = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even -= nums[i];
            } else {
                odd -= nums[i];
            }
            if (odd_ + even == odd + even_) {
                res++;
            }
            if (i % 2 == 0) {
                even_ += nums[i];
            } else {
                odd_ += nums[i];
            }
        }
        return res;
    }
};