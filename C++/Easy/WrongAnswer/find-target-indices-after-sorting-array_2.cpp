class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == target) {
                res.push_back(i);
            }
        }
        sort(res.begin(), res.end());
        return res;
    }
};