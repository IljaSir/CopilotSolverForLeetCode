class Solution {
public:
    int minimumJumps(vector<int>& forbidden, int a, int b, int x) {
        
        unordered_set<int> forbid(forbidden.begin(), forbidden.end());
        unordered_set<int> visited;
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited.insert(0);
        while (!q.empty()) {
            auto [pos, step] = q.front();
            q.pop();
            if (pos == x) {
                return step;
            }
            int next = pos + a;
            if (next <= 6000 && !forbid.count(next) && !visited.count(next)) {
                visited.insert(next);
                q.push({next, step + 1});
            }
            next = pos - b;
            if (next >= 0 && !forbid.count(next) && !visited.count(next)) {
                visited.insert(next);
                q.push({next, step + 1});
            }
        }
        return -1;
    }
};