class Solution {
public:
    int minimumJumps(vector<int>& forbidden, int a, int b, int x) {
        
        unordered_set<int> f(forbidden.begin(), forbidden.end());
        unordered_set<int> visited;
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited.insert(0);
        while (!q.empty()) {
            auto [pos, step] = q.front();
            q.pop();
            if (pos == x) return step;
            vector<int> nextPos = {pos + a, pos - b};
            for (auto p : nextPos) {
                if (p < 0 || f.count(p) || visited.count(p)) continue;
                visited.insert(p);
                q.push({p, step + 1});
            }
        }
        return -1;
    }
};