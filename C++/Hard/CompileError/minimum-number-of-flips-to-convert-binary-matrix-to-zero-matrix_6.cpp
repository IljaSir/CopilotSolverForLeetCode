class Solution {
public:
    int minFlips(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int res = 0;
        vector<vector<int>> dirs = {{0, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        queue<vector<vector<int>>> q;
        q.push(mat);
        unordered_set<string> visited;
        visited.insert(serialize(mat));
        while(!q.empty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                vector<vector<int>> cur = q.front();
                q.pop();
                if(isZero(cur)) {
                    return res;
                }
                for(int x = 0; x < m; x++) {
                    for(int y = 0; y < n; y++) {
                        vector<vector<int>> next = cur;
                        for(auto dir : dirs) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            if(nx < 0 || nx >= m || ny < 0 || ny >= n) {
                                continue;
                            }
                            next[nx][ny] = next[nx][ny] == 1 ? 0 : 1;
                        }
                        string nextStr = serialize(next);
                        if(visited.count(nextStr)) {
                            continue;
                        }
                        q.push(next);
                        visited.insert(nextStr);
                    }
                }
            }
            res++;
        }
        return -1;
    }
};