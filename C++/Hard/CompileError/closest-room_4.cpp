class Solution {
public:
    vector<int> closestRoom(vector<vector<int>>& rooms, vector<vector<int>>& queries) {
        
        int n = rooms.size(), m = queries.size();
        vector<int> ans(m, 0);
        vector<pair<int, int>> q(m);
        for (int i = 0; i < m; ++i) {
            q[i] = { queries[i][1], i };
        }
        sort(q.begin(), q.end());
        sort(rooms.begin(), rooms.end(), [](const auto& a, const auto& b) { return a[1] > b[1]; });
        set<int> s;
        int j = 0;
        for (auto& [minSize, i] : q) {
            while (j < n && rooms[j][1] >= minSize) {
                s.insert(rooms[j][0]);
                ++j;
            }
            if (s.empty()) {
                ans[i] = -1;
                continue;
            }
            auto it = s.lower_bound(queries[i][0]);
            if (it == s.end()) {
                ans[i] = *prev(it);
            } else if (it == s.begin()) {
                ans[i] = *it;
            } else {
                int a = *it, b = *prev(it);
                ans[i] = abs(a - queries[i][0]) < abs(b - queries[i][0]) ? a : b;
            }
        } a; a;
                }
            }
        }
        return ans;
    }
};