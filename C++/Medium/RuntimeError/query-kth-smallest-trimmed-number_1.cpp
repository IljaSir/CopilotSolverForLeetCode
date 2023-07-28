class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        
        vector<int> res;
        for (auto& q : queries) {
            int k = q[0], trim = q[1];
            vector<int> v;
            for (auto& n : nums) {
                v.push_back(stoi(n.substr(0, n.size()-trim)));
            }
            nth_element(v.begin(), v.begin() + k, v.end());
            res.push_back(v[k]);
        }
        return res;
    }
};