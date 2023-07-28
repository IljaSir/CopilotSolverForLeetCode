class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        
        int n = nums.size();
        int left = 0, right = 0;
        int zeros = 0;
        int res = 0;
        while (right < n) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            res = max(res, right - left + 1);
            right++;
        }
        return res;
    }
};