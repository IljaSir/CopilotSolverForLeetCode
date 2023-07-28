class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        
        vector<int> indices;
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == target) {
                indices.push_back(i);
            }
        }
        
        sort(nums.begin(), nums.end());
        
        for (int i = 0; i < indices.size(); i++) {
            indices[i] = find(nums.begin(), nums.end(), target) - nums.begin();
        }
        
        return indices;
    }
};