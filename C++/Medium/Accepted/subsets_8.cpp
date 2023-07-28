class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<vector<int>> result;
        vector<int> tmp;
        result.push_back(tmp);
        if(nums.size() == 0) {
            return result;
        }
        for(int i = 0; i < nums.size(); i++) {
            int size = result.size();
            for(int j = 0; j < size; j++) {
                tmp = result[j];
                tmp.push_back(nums[i]);
                result.push_back(tmp);
            }
        }
        return result;
    }
};