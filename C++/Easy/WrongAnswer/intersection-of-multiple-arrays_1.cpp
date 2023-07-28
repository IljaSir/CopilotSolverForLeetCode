class Solution {
public:
    vector<int> intersection(vector<vector<int>>& nums) {
        
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums[i].size(); j++) {
                bool flag = true;
                for (int k = 0; k < nums.size(); k++) {
                    if (k == i) continue;
                    if (find(nums[k].begin(), nums[k].end(), nums[i][j]) == nums[k].end()) {
                        flag = false;
                        break;
                    }
                }
                if (flag && find(res.begin(), res.end(), nums[i][j]) == res.end()) {
                    res.push_back(nums[i][j]);
                }
            }
        }
        return res;
    }
};