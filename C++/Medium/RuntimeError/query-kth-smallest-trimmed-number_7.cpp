class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        
        vector<int> result;
        for (vector<int> q : queries) {
            int k = q[0], trim = q[1];
            vector<int> trimmedNums;
            for (string num : nums) {
                trimmedNums.push_back(stoi(num.substr(0, num.length() - trim)));
            }
            sort(trimmedNums.begin(), trimmedNums.end());
            result.push_back(trimmedNums[k - 1]);
        }
        return result;
    }
};