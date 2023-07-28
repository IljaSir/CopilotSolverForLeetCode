class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        
        int n = arr.size();
        vector<int> ans;
        for (auto q: queries) {
            int x = 0;
            for (int i = q[0]; i <= q[1]; i++) {
                x ^= arr[i];
            }
            ans.push_back(x);
        }
        return ans;
    }
};