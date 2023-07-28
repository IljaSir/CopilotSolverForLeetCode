class Solution {
public:
    vector<int> closestRoom(vector<vector<int>>& rooms, vector<vector<int>>& queries) {
        
        int n = rooms.size();
        int m = queries.size();
        vector<int> ans(m, -1);
        vector<int> idx(m, 0);
        for (int i = 0; i < m; ++i) {
            idx[i] = i;
        }
        sort(rooms.begin(), rooms.end(), [](vector<int>& a, vector<int>& b) {
            return a[1] > b[1];
        });
        sort(idx.begin(), idx.end(), [&queries](int i, int j) {
            return queries[i][1] > queries[j][1];
        });
        set<int> st;
        int j = 0;
        for (int i = 0; i < m; ++i) {
            int q = idx[i];
            while (j < n && rooms[j][1] >= queries[q][1]) {
                st.insert(rooms[j][0]);
                ++j;
            }
            if (st.empty()) {
                continue;
            }
            auto it = st.lower_bound(queries[q][0]);
            if (it != st.end()) {
                if (ans[q] == -1 || abs(*it - queries[q][0]) < abs(ans[q] - queries[q][0])) {
                    ans[q] = *it;
                } b;
            }
        }
        return ans;
    }
};