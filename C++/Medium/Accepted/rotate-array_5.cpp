class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        
        int n = nums.size();
        k %= n;
        if (k == 0) return;
        vector<int> tmp(k);
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[n - k + i];
        }
        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
    }
};