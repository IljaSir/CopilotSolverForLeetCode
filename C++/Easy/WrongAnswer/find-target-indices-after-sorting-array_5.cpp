class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        
        vector<int> indices;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == target) {
                indices.push_back(i);
            }
        }
        return indices;
    }
};