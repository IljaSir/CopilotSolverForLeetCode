class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        
        vector<int> res;
        for (auto &q : queries) {
            int k = q[0], trim = q[1];
            vector<int> tmp;
            for (auto &s : nums) {
                tmp.push_back(stoi(s.substr(0, trim)));
            }
            sort(tmp.begin(), tmp.end());
            res.push_back(tmp[k - 1]);
        }
        return res;
    }
};