class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        
        vector<int> pre;
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) {
                pre.push_back(arr[i]);
            } else {
                pre.push_back(pre[i-1] ^ arr[i]);
            }
        }
        vector<int> res;
        for (int i = 0; i < queries.size(); i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                res.push_back(pre[r]);
            } else {
                res.push_back(pre[r] ^ pre[l-1]);
            }
        }
        return res;
    }
};