class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        
        unordered_map<int, int> mp;
        mp[1] = 0;
        queue<int> q;
        q.push(1);
        while (!q.empty()) {
            int cur = q.front(); q.pop();
            int steps = mp[cur];
            if (cur == target) return steps;
            if (cur * 2 <= target && mp.count(cur * 2) == 0) {
                mp[cur * 2] = steps + 1;
                q.push(cur * 2);
            }
            if (cur + 1 <= target && mp.count(cur + 1) == 0) {
                mp[cur + 1] = steps + 1;
                q.push(cur + 1);
            }
        }
        return -1;
    }
};