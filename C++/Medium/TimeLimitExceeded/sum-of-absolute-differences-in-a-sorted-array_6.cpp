class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        
        int size = nums.size();
        vector<int> result(size);
        for (int i = 0; i < size; i++) {
            result[i] = i * nums[i] - accumulate(nums.begin(), nums.begin() + i, 0);
            result[i] += accumulate(nums.begin() + i + 1, nums.end(), 0) - (size - i - 1) * nums[i];
        }
        return result;
    }
};