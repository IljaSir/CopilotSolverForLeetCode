class Solution {
public:
    vector<int> closestRoom(vector<vector<int>>& rooms, vector<vector<int>>& queries) {
        
        int n = rooms.size();
        vector<int> ans(queries.size());
        vector<int> idx(queries.size());
        iota(idx.begin(), idx.end(), 0);
        sort(idx.begin(), idx.end(), [&](int a, int b) {
            return queries[a][1] > queries[b][1];
        });
        sort(rooms.begin(), rooms.end(), [&](vector<int>& a, vector<int>& b) {
            return a[1] > b[1];
        });
        set<int> st;
        int j = 0;
        for (int i = 0; i < queries.size(); i++) {
            while (j < n && rooms[j][1] >= queries[idx[i]][1]) {
                st.insert(rooms[j][0]);
                j++;
            }
            if (st.empty()) {
                ans[idx[i]] = -1;
            } else {
                auto it = st.lower_bound(queries[idx[i]][0]);
                int id = *it;
                if (it != st.begin()) {
                    int id2 = *prev(it);
                    if (abs(id2 - queries[idx[i]][0]) <= abs(id - queries[idx[i]][0])) {
                        id = id2;
                    }
                }
                ans[idx[i]] = id;
            }
        }
        return ans;
    }
};