class Solution {
public:
    vector<int> closestRoom(vector<vector<int>>& rooms, vector<vector<int>>& queries) {
        
        int n = rooms.size();
        int m = queries.size();
        vector<int> ans(m, -1);
        vector<int> ids(m);
        iota(ids.begin(), ids.end(), 0);
        sort(ids.begin(), ids.end(), [&](int i, int j) {
            return queries[i][1] > queries[j][1];
        });
        sort(rooms.begin(), rooms.end(), [&](vector<int> &a, vector<int> &b) {
            return a[1] > b[1];
        });
        set<int> st;
        int j = 0;
        for (int i = 0; i < m; i++) {
            int id = ids[i];
            int p = queries[id][0], s = queries[id][1];
            while (j < n && rooms[j][1] >= s) {
                st.insert(rooms[j][0]);
                j++;
            }
            if (st.empty()) continue;
            auto it = st.lower_bound(p);
            int x = -1;
            if (it != st.end()) {
                x = *it;
            }
            if (it != st.begin()) {
                it--;
                int y = *it;
                if (x == -1 || abs(x - p) >= abs(y - p)) {
                    s = y;
                }
            }
            ans[id] = x;
        }
        return ans;
    }
};