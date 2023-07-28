class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        
        vector<int> res(2);
        for (int i = 0; i < nums.size(); ++i) {
            int idx = abs(nums[i]) - 1;
            if (nums[idx] < 0)
                res[0] = abs(nums[i]);
            else
                nums[idx] *= -1;
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] > 0) {
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }
};