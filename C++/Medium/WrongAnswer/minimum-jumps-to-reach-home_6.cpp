class Solution {
public:
    int minimumJumps(vector<int>& forbidden, int a, int b, int x) {
        
        set<int> forb(forbidden.begin(), forbidden.end());
        if (forb.count(0) || forb.count(x)) return -1;
        if (x == 0) return 0;
        map<int, int> dist;
        dist[0] = 0;
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            int d = dist[cur];
            int next = cur + a;
            if (next == x) return d + 1;
            if (next < x && !forb.count(next)) {
                if (!dist.count(next) || d + 1 < dist[next]) {
                    dist[next] = d + 1;
                    q.push(next);
                }
            }
            next = cur - b;
            if (next == x) return d + 1;
            if (next > 0 && !forb.count(next)) {
                if (!dist.count(next) || d + 1 < dist[next]) {
                    dist[next] = d + 1;
                    q.push(next);
                }
            }
        }
        return -1;
    }
};