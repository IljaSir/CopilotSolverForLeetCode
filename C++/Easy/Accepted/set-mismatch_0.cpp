class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        
        vector<int> res(2, 0);
        for (int i = 0; i < nums.size(); ++i) {
            int index = abs(nums[i]) - 1;
            if (nums[index] < 0) res[0] = index + 1;
            else nums[index] = -nums[index];
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] > 0) res[1] = i + 1;
        }
        return res;
    }
};