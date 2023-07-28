class Solution {
public:
    int minimumJumps(vector<int>& forbidden, int a, int b, int x) {
        
        unordered_set<int> forb(forbidden.begin(), forbidden.end());
        if (forb.count(0) > 0) return -1;
        if (x == 0) return 0;
        queue<int> q;
        q.push(0);
        int step = 0;
        unordered_set<int> visited;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.front();
                q.pop();
                if (forb.count(cur) > 0) continue;
                if (cur == x) return step;
                visited.insert(cur);
                // forward
                int next = cur + a;
                if (next <= x && visited.count(next) == 0) q.push(next);
                // backward
                next = cur - b;
                if (next > 0 && visited.count(next) == 0) q.push(next);
            }
            step++;
        }
        return -1;
    }
};