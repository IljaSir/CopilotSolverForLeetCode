class Solution {
public:
    int minFlips(vector<vector<int>>& mat) {
        
        int row = mat.size();
        int col = mat[0].size();
        int total = row * col;
        int res = 0;
        queue<int> q;
        unordered_set<int> visited;
        int start = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                start += mat[i][j] << (i * col + j);
            }
        }
        q.push(start);
        visited.insert(start);
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.front();
                q.pop();
                if (cur == 0) {
                    return res;
                }
                for (int j = 0; j < total; j++) {
                    int next = cur;
                    int x = j / col;
                    int y = j % col;
                    next = flip(next, x, y, col);
                    next = flip(next, x - 1, y, col);
                    next = flip(next, x + 1, y, col);
                    next = flip(next, x, y - 1, col);
                    next = flip(next, x, y + 1, col);
                    if (visited.find(next) == visited.end()) {
                        q.push(next);
                        visited.insert(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }
    int flip(int num, int x, int y, int col) {
        if (x < 0 || x >= col || y < 0 || y >= col) {
            return num;
        }
        int pos = x * col + y;
        return num ^ (1 << pos);
    }
};