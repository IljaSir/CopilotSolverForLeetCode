class Solution {
public:
    vector<int> closestRoom(vector<vector<int>>& rooms, vector<vector<int>>& queries) {
        
        int n = rooms.size();
        int m = queries.size();
        vector<int> ans(m, 0);
        vector<int> qidx(m, 0);
        for (int i = 0; i < m; i++) qidx[i] = i;
        sort(rooms.begin(), rooms.end(), [](const vector<int>& a, const vector<int>& b) { return a[1] > b[1]; });
        sort(qidx.begin(), qidx.end(), [&](const int& a, const int& b) { return queries[a][1] > queries[b][1]; });
        set<int> s;
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && rooms[j][1] >= queries[qidx[i]][1]) {
                s.insert(rooms[j++][0]);
            }
            if (s.empty()) {
                ans[qidx[i]] = -1;
                continue;
            }
            auto it = s.lower_bound(queries[qidx[i]][0]);
            if (it == s.end()) {
                ans[qidx[i]] = *prev(it);
            } else if (it == s.begin()) {
                ans[qidx[i]] = *it;
            } else {
                int a = *it;
                int b = *prev(it);
                ans[qidx[i]] = abs(a - queries[qidx[i]][0]) < abs(b - queries[qidx[i]][0]) ? a : b;
            }
        }
        return ans;
    }
};