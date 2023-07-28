class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        
        vector<int> in(n, 0);
        vector<vector<int>> out(n);
        for (auto& r: relations) {
            in[r[1]-1] += 1;
            out[r[0]-1].push_back(r[1]-1);
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (in[i] == 0) {
                q.push(i);
            }
        }
        vector<int> res(n, 0);
        while (!q.empty()) {
            int idx = q.front();
            q.pop();
            for (auto& o: out[idx]) {
                res[o] = max(res[o], res[idx] + time[idx]);
                in[o] -= 1;
                if (in[o] == 0) {
                    q.push(o);
                }
            }
        }
        int ans = 0;
        for (auto& r: res) {
            ans = max(ans, r);
        }
        return ans + time.back();
    }
};