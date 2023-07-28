class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> res(k);
        if (n == k) {
            return nums;
        }
        int top = -1;
        for (int i = 0; i < n; ++i) {
            while (top >= 0 && res[top] < nums[i] && n - i > k - top - 1) {
                --top;
            }
            if (top < k - 1) {
                res[++top] = nums[i];
            }
        }
        return res;
    }
};