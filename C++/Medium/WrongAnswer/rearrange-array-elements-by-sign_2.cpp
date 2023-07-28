class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int i = 0;
        int j = nums.size() - 1;
        vector<int> res;
        while (i < j) {
            res.push_back(nums[i++]);
            res.push_back(nums[j--]);
        }
        if (i == j) {
            res.push_back(nums[i]);
        }
        return res;
    }
};