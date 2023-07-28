class Solution {
public:
    int stoneGameVIII(vector<int>& stones) {
        
        int n = stones.size();
        vector<int> pre(n);
        pre[0] = stones[0];
        for (int i = 1; i < n; ++i) pre[i] = pre[i - 1] + stones[i];
        int res = pre[n - 1];
        for (int i = n - 2; i > 0; --i) {
            res = max(res, pre[i] - res);
        }
        return res;
    }
};