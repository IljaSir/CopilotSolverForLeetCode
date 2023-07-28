class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res(n);
        vector<int> sorted;
        for (int i = n - 1; i >= 0; i--) {
            int index = lower_bound(sorted.begin(), sorted.end(), nums[i]) - sorted.begin();
            res[i] = index;
            sorted.insert(sorted.begin() + index, nums[i]);
        }
        return res;
    }
};