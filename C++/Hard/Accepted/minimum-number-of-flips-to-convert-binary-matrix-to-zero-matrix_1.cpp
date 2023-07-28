class Solution {
public:
    int minFlips(vector<vector<int>>& mat) {
        
        int m = mat.size(), n = mat[0].size();
        int target = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                target |= (mat[i][j] << (i * n + j));
            }
        }
        int start = 0;
        queue<int> q;
        q.push(start);
        unordered_set<int> visited;
        visited.insert(start);
        int steps = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.front();
                q.pop();
                if (cur == target) {
                    return steps;
                }
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int next = cur ^ (1 << (j * n + k));
                        if (j > 0) {
                            next ^= (1 << ((j - 1) * n + k));
                        }
                        if (j < m - 1) {
                            next ^= (1 << ((j + 1) * n + k));
                        }
                        if (k > 0) {
                            next ^= (1 << (j * n + k - 1));
                        }
                        if (k < n - 1) {
                            next ^= (1 << (j * n + k + 1));
                        }
                        if (visited.count(next) == 0) {
                            q.push(next);
                            visited.insert(next);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
};