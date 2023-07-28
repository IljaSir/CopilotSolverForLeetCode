class Solution {
public:
    vector<int> waysToFillArray(vector<vector<int>>& queries) {
        
        vector<int> ans;
        for (auto& q : queries) {
            int n = q[0], k = q[1];
            ans.push_back(numWays(n, k));
        }
        return ans;
    }
};