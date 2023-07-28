class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0, j = 0;
        int k = 1;
        int res = 0;
        while (j < n) {
            if (nums[j] == 0) k--;
            while (k < 0) {
                if (nums[i] == 0) k++;
                i++;
            }
            res = max(res, j - i);
            j++;
        }
        return res;
    }
};