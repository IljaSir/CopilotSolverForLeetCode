class Solution {
public:
    vector<int> intersection(vector<vector<int>>& nums) {
        
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums[i].size(); j++) {
                bool all = true;
                for (int k = 0; k < nums.size(); k++) {
                    if (k == i) continue;
                    if (find(nums[k].begin(), nums[k].end(), nums[i][j]) == nums[k].end()) {
                        all = false;
                        break;
                    }
                }
                if (all && find(result.begin(), result.end(), nums[i][j]) == result.end()) {
                    result.push_back(nums[i][j]);
                }
            }
        }
        sort(result.begin(), result.end());
        return result;
    }
};