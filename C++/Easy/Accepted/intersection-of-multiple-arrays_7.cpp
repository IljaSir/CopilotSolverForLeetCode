class Solution {
public:
    vector<int> intersection(vector<vector<int>>& nums) {
        
        int n = nums.size();
        vector<int> res;
        if (n == 0) return res;
        set<int> s;
        for (int i=0; i<nums[0].size(); i++) {
            s.insert(nums[0][i]);
        }
        for (int i=1; i<n; i++) {
            set<int> t;
            for (int j=0; j<nums[i].size(); j++) {
                if (s.find(nums[i][j]) != s.end()) {
                    t.insert(nums[i][j]);
                }
            }
            s = t;
        }
        for (auto it = s.begin(); it != s.end(); it++) {
            res.push_back(*it);
        }
        return res;
    }
};