class Solution {
public:
    vector<int> createTargetArray(vector<int>& nums, vector<int>& index) {
        
        vector<int> target;
        for (int i = 0; i < nums.size(); i++) {
            auto it = target.begin();
            target.insert(it + index[i], nums[i]);
        }
        return target;
    }
};