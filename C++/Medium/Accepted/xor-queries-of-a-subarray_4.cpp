class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        
        vector<int> ans;
        ans.push_back(arr[0]);
        for (int i = 1; i < arr.size(); i++) {
            ans.push_back(ans[i - 1] ^ arr[i]);
        }
        for (auto& q: queries) {
            int l = q[0], r = q[1];
            if (l == 0) {
                ans.push_back(ans[r]);
            } else {
                ans.push_back(ans[r] ^ ans[l - 1]);
            }
        }
        return vector<int>(ans.end() - queries.size(), ans.end());
    }
};