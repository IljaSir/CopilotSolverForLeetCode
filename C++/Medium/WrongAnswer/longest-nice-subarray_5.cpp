class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = i; j < n; j++) {
                x = min(x, nums[j]);
                if (j - i + 1 > ans && x == nums[j]) {
                    ans = j - i + 1;
                }
            }
        }
        return ans;
    }
};