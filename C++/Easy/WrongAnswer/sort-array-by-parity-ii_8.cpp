class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& nums) {
        
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            if ((i % 2 == 0 && nums[i] % 2 == 0) || (i % 2 == 1 && nums[i] % 2 == 1)) {
                res.push_back(nums[i]);
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            if ((i % 2 == 0 && nums[i] % 2 == 1) || (i % 2 == 1 && nums[i] % 2 == 0)) {
                res.push_back(nums[i]);
            }
        }
        return res;
    }
};