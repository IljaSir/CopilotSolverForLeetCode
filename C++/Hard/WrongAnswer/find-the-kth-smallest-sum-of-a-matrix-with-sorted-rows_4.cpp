class Solution {
public:
    int kthSmallest(vector<vector<int>>& mat, int k) {
        
        int n = mat.size();
        int m = mat[0].size();
        vector<int> sums(n, 0);
        for (int i = 0; i < n; i++) {
            sums[i] = mat[i][0];
        }
        priority_queue<int> pq(sums.begin(), sums.end());
        while (k-- > 1) {
            int sum = pq.top();
            pq.pop();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] > sum - sums[i]) {
                        break;
                    }
                    pq.push(sum - sums[i] + mat[i][j]);
                }
                sums[i] = mat[i][0];
            }
        }
        return pq.top();
    }
};