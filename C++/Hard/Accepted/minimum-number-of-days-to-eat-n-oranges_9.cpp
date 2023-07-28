class Solution {
public:
    int minDays(int n) {
        
        queue<int> q;
        unordered_set<int> visited;
        q.push(n);
        visited.insert(n);
        int depth = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.front();
                q.pop();
                if (cur == 0) return depth;
                if (cur % 3 == 0 && !visited.count(cur / 3)) {
                    q.push(cur / 3);
                    visited.insert(cur / 3);
                }
                if (cur % 2 == 0 && !visited.count(cur / 2)) {
                    q.push(cur / 2);
                    visited.insert(cur / 2);
                }
                if (!visited.count(cur - 1)) {
                    q.push(cur - 1);
                    visited.insert(cur - 1);
                }
            }
            depth++;
        }
        return depth;
    }
};