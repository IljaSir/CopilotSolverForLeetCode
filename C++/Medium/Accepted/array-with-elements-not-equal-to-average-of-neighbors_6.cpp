class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        vector<int> res(nums.size());
        int i = 0, j = nums.size() - 1, k = 0;
        while (i < j) {
            res[k++] = nums[i++];
            res[k++] = nums[j--];
        }
        if (i == j) res[k] = nums[i];
        return res;
    }
};