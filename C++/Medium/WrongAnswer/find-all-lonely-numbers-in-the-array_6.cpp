class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        
        vector<int> res;
        for(int i = 0; i < nums.size(); ++i) {
            if((i == 0 || nums[i] != nums[i-1]) && (i == nums.size()-1 || nums[i] != nums[i+1])) {
                res.push_back(nums[i]);
            }
        }
        return res;
    }
};