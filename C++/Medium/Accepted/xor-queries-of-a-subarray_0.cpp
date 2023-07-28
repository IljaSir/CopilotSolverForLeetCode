class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        
        int n = arr.size();
        vector<int> pre(n+1, 0);
        for (int i = 1; i <= n; ++i) {
            pre[i] = pre[i-1] ^ arr[i-1];
        }
        vector<int> res;
        for (auto& q : queries) {
            res.push_back(pre[q[0]] ^ pre[q[1]+1]);
        }
        return res;
    }
};