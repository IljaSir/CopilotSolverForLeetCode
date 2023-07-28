class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        int j = 0;
        int maxBit = 0;
        int ans = 0;
        while (i < n && j < n) {
            maxBit = max(maxBit, nums[j]);
            if (maxBit == nums[j]) {
                ans = max(ans, j - i);
            }
            if (maxBit & nums[j+1]) {
                j++;
            } else {
                i = j + 1;
                j = i;
                maxBit = 0;
            }
        }
        return ans;
    }
};