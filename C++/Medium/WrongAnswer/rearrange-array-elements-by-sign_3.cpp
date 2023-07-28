class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        vector<int> res;
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            res.push_back(nums[j]);
            res.push_back(nums[i]);
            --j;
            ++i;
        }
        if (i == j) {
            res.push_back(nums[i]);
        }
        return res;
    }
};