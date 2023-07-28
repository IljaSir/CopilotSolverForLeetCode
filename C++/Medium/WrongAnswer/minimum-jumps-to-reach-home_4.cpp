class Solution {
public:
    int minimumJumps(vector<int>& forbidden, int a, int b, int x) {
        
        unordered_set<int> seen(forbidden.begin(), forbidden.end());
        queue<pair<int, bool>> q;
        q.push({0, false});
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto [pos, back] = q.front();
                q.pop();
                if (pos == x) return step;
                if (seen.count(pos)) continue;
                seen.insert(pos);
                if (pos + a <= 6000) q.push({pos + a, false});
                if (!back && pos - b >= 0) q.push({pos - b, true});
            }
            ++step;
        }
        return -1;
    }
};