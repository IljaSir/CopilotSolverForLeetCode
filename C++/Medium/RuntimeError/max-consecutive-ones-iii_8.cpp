class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        
        int n = nums.size();
        int left = 0, right = 0;
        int maxLen = 0, count = 0;
        while (right < n) {
            if (nums[right] == 1) {
                right++;
                count++;
            } else {
                if (k > 0) {
                    k--;
                    right++;
                    count++;
                } else {
                    while (nums[left] == 1) {
                        left++;
                        count--;
                    }
                    left++;
                    count--;
                }
            }
            maxLen = max(maxLen, count);
        }
        return maxLen;
    }
};