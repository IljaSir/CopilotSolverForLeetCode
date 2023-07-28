class Solution {
public:
    int minFlips(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int k = m*n;
        unordered_set<int> visited;
        queue<int> q;
        int start = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                start |= mat[i][j] << (i*n+j);
            }
        }
        if (start == 0) return 0;
        visited.insert(start);
        q.push(start);
        int step = 0;
        while (!q.empty()) {
            step++;
            int size = q.size();
            for (int i=0; i<size; i++) {
                int cur = q.front();
                q.pop();
                for (int j=0; j<k; j++) {
                    int new_state = cur;
                    int r = j/n;
                    int c = j%n;
                    new_state ^= 1 << j;
                    if (r-1 >= 0) new_state ^= 1 << ((r-1)*n+c);
                    if (r+1 < m) new_state ^= 1 << ((r+1)*n+c);
                    if (c-1 >= 0) new_state ^= 1 << (r*n+c-1);
                    if (c+1 < n) new_state ^= 1 << (r*n+c+1);
                    if (new_state == 0) return step;
                    if (visited.count(new_state) == 0) {
                        q.push(new_state);
                        visited.insert(new_state);
                    }
                }
            }
        }
        return -1;
    }
};