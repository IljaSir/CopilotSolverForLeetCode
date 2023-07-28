class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        
        vector<int> res;
        int n = nums.size();
        int left = 0, right = k;
        int leftMax = nums[left], rightMax = nums[right];
        while (right < n - k) {
            for (int i = left; i < right; ++i) {
                leftMax = max(leftMax, nums[i]);
            }
            for (int i = right; i < right + k; ++i) {
                rightMax = max(rightMax, nums[i]);
            }
            if (leftMax < nums[right] && rightMax > nums[right]) {
                res.push_back(right);
            }
            leftMax = nums[++left];
            rightMax = nums[++right];
        }
        return res;
    }
};