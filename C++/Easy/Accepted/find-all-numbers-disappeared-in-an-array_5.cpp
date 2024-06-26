class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        
        vector<int> result;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            int index = abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                result.push_back(i + 1);
            }
        }
        return result;
    }
};