class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == target) {
                result.push_back(i);
            }
        }
        sort(result.begin(), result.end());
        return result;
    }
};