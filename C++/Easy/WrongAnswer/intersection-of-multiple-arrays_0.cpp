class Solution {
public:
    vector<int> intersection(vector<vector<int>>& nums) {
        
        vector<int> result;
        for (int i = 0; i < nums[0].size(); i++) {
            bool flag = true;
            for (int j = 1; j < nums.size(); j++) {
                if (find(nums[j].begin(), nums[j].end(), nums[0][i]) == nums[j].end()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.push_back(nums[0][i]);
            }
        }
        return result;
    }
};