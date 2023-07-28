class Solution {
public:
    int minFlips(vector<vector<int>>& mat) {
        
        int n = mat.size();
        int m = mat[0].size();
        int target = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                target |= mat[i][j] << (i * m + j);
        if(target == 0) return 0;
        vector<int> dirs = {0, 1, 0, -1, 0};
        queue<int> q;
        q.push(target);
        int step = 0;
        unordered_set<int> visited;
        visited.insert(target);
        while(!q.empty()) {
            int size = q.size();
            step++;
            for(int i = 0; i < size; i++) {
                int cur = q.front();
                q.pop();
                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < m; k++) {
                        int tmp = cur;
                        for(int l = 0; l < 4; l++) {
                            int x = j + dirs[l];
                            int y = k + dirs[l + 1];
                            if(x >= 0 && x < n && y >= 0 && y < m) {
                                tmp ^= 1 << (x * m + y);
                            }
                        }
                        if(tmp == 0) return step;
                        if(visited.count(tmp)) continue;
                        q.push(tmp);
                        visited.insert(tmp);
                    }
                }
            }
        }
        return -1;
    }
};