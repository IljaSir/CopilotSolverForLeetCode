class Solution {
public:
    vector<int> closestRoom(vector<vector<int>>& rooms, vector<vector<int>>& queries) {
        
        int m = rooms.size();
        int n = queries.size();
        vector<int> ans(n);
       vector<int> order(n);
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        sort(rooms.begin(), rooms.end(), [](const auto& a, const auto& b) {
            return a[1] > b[1];
        });
        sort(order.begin(), order.end(), [&](const auto& a, const auto& b) {
            return queries[a][1] > queries[b][1];
        });
        set<int> ids;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int id = order[i];
            while (idx < m && rooms[idx][1] >= queries[id][1]) {
                ids.insert(rooms[idx][0]);
                idx++;
            }
            if (ids.empty()) {
                ans[id] = -1;
                continue;
            }
            auto it = ids.lower_bound(queries[id][0]);
            if (it == ids.end()) {
                ans[id] = *prev(it);
            } else if (it == ids.begin()) {
                ans[id] = *it;
            } else {
                int x = *it;
                int y = *prev(it);
                if (abs(x - queries[id][0]) < abs(y - queries[id][0])) {
                    ans[id] = x;
                } else if (abs(x - queries[id][0]) > abs(y - queries[id][0])) {
                    ans[id] = y;
                } else {
                    ns[id] = min(x, y)
        return an
            }
        }
        return ans;
    }
};