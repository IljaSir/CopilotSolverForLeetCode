class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        
        vector<vector<int>> result;
        if (nums.size() == 1) {
            result.push_back(nums);
            return result;
        }
        for (int i = 0; i < nums.size(); i++) {
            vector<int> temp = nums;
            temp.erase(temp.begin() + i);
            vector<vector<int>> tempResult = permute(temp);
            for (int j = 0; j < tempResult.size(); j++) {
                tempResult[j].insert(tempResult[j].begin(), nums[i]);
                result.push_back(tempResult[j]);
            }
        }
        return result;
    }
};