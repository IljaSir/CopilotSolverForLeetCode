class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        
        int ans = 0;
        int n = nums.size();
        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n && nums[j] > nums[j - 1]) ++j;
            ans = max(ans, j - i);
            i = j;
        }
        return ans;
    }
};