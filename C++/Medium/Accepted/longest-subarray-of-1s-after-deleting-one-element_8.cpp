class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int N = nums.size();
        int left = 0, right = 0, k = 1;
        int ans = 0;
        while (right < N) {
            if (nums[right] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
            ans = max(ans, right - left);
            right++;
        }
        return ans;
    }
};