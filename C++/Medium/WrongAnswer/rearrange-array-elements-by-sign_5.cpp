class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<int> ans(n);
        int i = 0, j = n/2;
        for (int k = 0; k < n; ++k) {
            if (k % 2 == 0) {
                ans[k] = nums[i++];
            } else {
                ans[k] = nums[j++];
            }
        }
        return ans;
    }
};