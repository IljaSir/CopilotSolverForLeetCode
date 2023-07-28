class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        vector<int> ans(nums.size());
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums.size()) {
            ans[k++] = nums[j];
            j += 2;
            i++;
        }
        i = 0;
        j = 1;
        while (i < nums.size()) {
            ans[k++] = nums[j];
            j += 2;
            i++;
        }
        return ans;
    }
};