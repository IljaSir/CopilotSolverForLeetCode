class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> res;
        vector<int> t;
        res.push_back(t);
        for(int i = 0; i < n; i++){
            int m = res.size();
            for(int j = 0; j < m; j++){
                t = res[j];
                t.push_back(nums[i]);
                res.push_back(t);
            }
        }
        return res;
    }
};