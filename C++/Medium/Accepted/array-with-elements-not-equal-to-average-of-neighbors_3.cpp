class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        vector<int> res;
        int n = nums.size();
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            res.push_back(nums[i]);
            if (i < j) {
                res.push_back(nums[j]);
            }
        }
        return res;
    }
};