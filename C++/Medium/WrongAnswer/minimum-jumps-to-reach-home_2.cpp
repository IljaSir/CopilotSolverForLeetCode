class Solution {
public:
    int minimumJumps(vector<int>& forbidden, int a, int b, int x) {
        
        unordered_set<int> forb(forbidden.begin(), forbidden.end());
        if (forb.count(0)) return -1;
        if (x == 0) return 0;
        queue<int> q;
        q.push(0);
        int step = 0;
        while (!q.empty()) {
            int n = q.size();
            while (n--) {
                int cur = q.front();
                q.pop();
                int next = cur + a;
                if (next == x) return step + 1;
                if (next < x && !forb.count(next)) {
                    q.push(next);
                    forb.insert(next);
                }
                next = cur - b;
                if (next >= 0 && !forb.count(next)) {
                    q.push(next);
                    forb.insert(next);
                }
            }
            step++;
        }
        return -1;
    }
};