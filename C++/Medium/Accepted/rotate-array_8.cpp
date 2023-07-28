class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (k > n) k %= n;
        if (k == 0) return;
        vector<int> tmp(n);
        for (int i = 0; i < n; i++) {
            tmp[(i + k) % n] = nums[i];
        }
        nums = tmp;
    }
};