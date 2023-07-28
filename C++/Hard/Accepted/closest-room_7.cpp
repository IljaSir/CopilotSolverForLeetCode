class Solution {
public:
    vector<int> closestRoom(vector<vector<int>>& rooms, vector<vector<int>>& queries) {
        
        vector<int> ans(queries.size());
        vector<int> qids(queries.size());
        for (int i = 0; i < queries.size(); ++i) {
            qids[i] = i;
        }
        sort(qids.begin(), qids.end(), [&queries](int i, int j) {
            return queries[i][1] > queries[j][1];
        });
        sort(rooms.begin(), rooms.end(), [](const auto& a, const auto& b) {
            return a[1] > b[1];
        });
        set<int> ids;
        int j = 0;
        for (int i = 0; i < queries.size(); ++i) {
            while (j < rooms.size() && rooms[j][1] >= queries[qids[i]][1]) {
                ids.insert(rooms[j++][0]);
            }
            if (ids.empty()) {
                ans[qids[i]] = -1;
                continue;
            }
            auto it = ids.lower_bound(queries[qids[i]][0]);
            if (it == ids.end()) {
                ans[qids[i]] = *prev(it);
            } else if (it == ids.begin()) {
                ans[qids[i]] = *it;
            } else {
                int a = *it;
                int b = *prev(it);
                ans[qids[i]] = (queries[qids[i]][0] - b) <= (a - queries[qids[i]][0]) ? b : a;
            }
        }
        return ans;
    }
};