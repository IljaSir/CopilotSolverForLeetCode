class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        
        vector<int> res(nums.size(), 0);
        vector<int> sorted;
        for (int i = nums.size() - 1; i >= 0; --i) {
            int index = lower_bound(sorted.begin(), sorted.end(), nums[i]) - sorted.begin();
            res[i] = index;
            sorted.insert(sorted.begin() + index, nums[i]);
        }
        return res;
    }
};