class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        
        vector<int> ans;
        for (auto& q : queries) {
            int k = q[0], trim = q[1];
            vector<int> cur;
            for (auto& num : nums) {
                cur.push_back(stoi(num.substr(0, num.size() - trim)));
            }
            sort(cur.begin(), cur.end());
            ans.push_back(cur[k - 1]);
        }
        return ans;
    }
};