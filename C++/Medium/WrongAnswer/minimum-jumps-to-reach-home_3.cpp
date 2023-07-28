class Solution {
public:
    int minimumJumps(vector<int>& forbidden, int a, int b, int x) {
        
        unordered_set<int> forb(forbidden.begin(), forbidden.end());
        queue<pair<int, bool>> q;
        q.push({0, false});
        unordered_set<int> visited;
        visited.insert(0);
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto p = q.front();
                q.pop();
                if (p.first == x) {
                    return step;
                }
                int next = p.first + a;
                if (next <= 6000 && !forb.count(next) && !visited.count(next)) {
                    q.push({next, false});
                    visited.insert(next);
                }
                if (!p.second) {
                    next = p.first - b;
                    if (next >= 0 && !forb.count(next) && !visited.count(next)) {
                        q.push({next, true});
                        visited.insert(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
};