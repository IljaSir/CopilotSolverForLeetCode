class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        
        vector<int> res(nums.size(), 0);
        vector<int> sorted;
        for (int i = nums.size() - 1; i >= 0; --i) {
            auto it = lower_bound(sorted.begin(), sorted.end(), nums[i]);
            res[i] = it - sorted.begin();
            sorted.insert(it, nums[i]);
        }
        return res;
    }
};