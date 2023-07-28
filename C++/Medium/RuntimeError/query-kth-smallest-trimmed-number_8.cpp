class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        
        vector<int> result;
        for (auto &q : queries) {
            int k = q[0];
            int trim = q[1];
            vector<int> nums_trim;
            for (auto &n : nums) {
                nums_trim.push_back(stoi(n.substr(0, trim)));
            }
            nth_element(nums_trim.begin(), nums_trim.begin() + k, nums_trim.end());
            result.push_back(nums_trim[k]);
        }
        return result;
    }
};