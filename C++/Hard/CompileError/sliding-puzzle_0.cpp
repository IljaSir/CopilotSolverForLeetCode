class Solution {
public:
    int slidingPuzzle(vector<vector<int>>& board) {
        
        string target = "123450";
        string start = "";
        for (auto row : board) {
            for (auto col : row) {
                start += to_string(col);
            }
        }
        if (start == target) return 0;
        unordered_set<string> visited;
        queue<string> q;
        q.push(start);
        visited.insert(start);
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                string cur = q.front();
                q.pop();
                int index = cur.find('0');
                int row = index / 3;
                int col = index % 3;
                for (auto& dir : dirs) {
                    int next_row = row + dir[0];
                    int next_col = col + dir[1];
                    if (next_row < 0 || next_row >= 2 || next_col < 0 || next_col >= 3) continue;
                    int next_index = next_row * 3 + next_col;
                    string next = cur;
                    swap(next[index], next[next_index]);
                    if (next == target) return step + 1;
                    if (visited.find(next) != visited.end()) continue;
                    visited.insert(next);
                    q.push(next);
                }
            }
            step++;
        }
        return -1;
    }
};