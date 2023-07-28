class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        
        vector<int> res;
        for (auto q : queries) {
            int x = arr[q[0]];
            for (int i = q[0] + 1; i <= q[1]; i++) {
                x ^= arr[i];
            }
            res.push_back(x);
        }
        return res;
    }
};