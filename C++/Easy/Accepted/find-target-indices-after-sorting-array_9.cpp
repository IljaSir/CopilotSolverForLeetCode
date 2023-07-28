class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        
        vector<int> result;
        sort(nums.begin(), nums.end());
        int i = 0;
        while (i < nums.size()) {
            if (nums[i] == target) {
                result.push_back(i);
            }
            i++;
        }
        return result;
    }
};