class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] % 2 == 0) {
                res.insert(res.begin(), nums[i]);
            } else {
                res.push_back(nums[i]);
            }
        }
        return res;
    }
};