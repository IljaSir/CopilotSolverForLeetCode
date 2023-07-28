class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        
        vector<int> result;
        vector<int> sorted = nums;
        sort(sorted.begin(), sorted.end());
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == target) {
                int index = find(sorted.begin(), sorted.end(), target) - sorted.begin();
                result.push_back(index);
                sorted[index] = -1;
            }
        }
        return result;
    }
};