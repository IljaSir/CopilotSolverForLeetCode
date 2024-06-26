class Solution {
public:
    string optimalDivision(vector<int>& nums) {
        
        string res;
        if (nums.size() == 1) {
            return to_string(nums[0]);
        }
        if (nums.size() == 2) {
            return to_string(nums[0]) + "/" + to_string(nums[1]);
        }
        res = to_string(nums[0]) + "/(" + to_string(nums[1]);
        for (int i = 2; i < nums.size(); ++i) {
            res += "/" + to_string(nums[i]);
        }
        res += ")";
        return res;
    }
};