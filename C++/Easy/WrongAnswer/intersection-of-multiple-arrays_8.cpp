class Solution {
public:
    vector<int> intersection(vector<vector<int>>& nums) {
        
        int n = nums.size();
        if(n == 0) return {};
        vector<int> ans;
        unordered_set<int> s;
        for(int i = 0; i < nums[0].size(); i++) {
            s.insert(nums[0][i]);
        }
        for(int i = 1; i < n; i++) {
            unordered_set<int> temp;
            for(int j = 0; j < nums[i].size(); j++) {
                if(s.find(nums[i][j]) != s.end()) {
                    temp.insert(nums[i][j]);
                }
            }
            s = temp;
        }
        for(auto x: s) {
            ans.push_back(x);
        }
        return ans;
    }
};