class Solution {
public:
    vector<int> closestRoom(vector<vector<int>>& rooms, vector<vector<int>>& queries) {
        
        int n = rooms.size();
        int k = queries.size();
        vector<int> ans(k);
        vector<vector<int>> q(k, vector<int>(3));
        for (int i = 0; i < k; ++i) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        sort(rooms.begin(), rooms.end(), [](vector<int> &a, vector<int> &b) {
            return a[1] > b[1];
        });
        sort(q.begin(), q.end(), [](vector<int> &a, vector<int> &b) {
            return a[1] > b[1];
        });
        set<int> s;
        int j = 0;
        for (int i = 0; i < k; ++i) {
            while (j < n && rooms[j][1] >= q[i][1]) {
                s.insert(rooms[j++][0]);
            }
            auto it = s.lower_bound(q[i][0]);
            if (it == s.end()) {
                if (it == s.begin()) {
                    ans[q[i][2]] = -1;
                } else {
                    ans[q[i][2]] = *--it;
                }
            } else {
                if (it == s.begin()) {
                    ans[q[i][2]] = *it;
                } else {
                    int a = *it;
                    int b = *--it;
                    ans[q[i][2]] = (q[i][0] - b <= a - q[i][0]) ? b : a;
                }
            }
        }
        return ans;
    }
};