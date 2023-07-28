class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        
        vector<int> result;
        for (auto& q : queries) {
            int k = q[0];
            int trim = q[1];
            vector<int> v;
            for (auto& s : nums) {
                v.push_back(stoi(s.substr(0, trim)));
            }
            sort(v.begin(), v.end());
            result.push_back(v[k-1]);
        }
        return result;
    }
};