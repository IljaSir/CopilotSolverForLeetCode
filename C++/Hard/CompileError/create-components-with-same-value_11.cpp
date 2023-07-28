class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.si);
        vector<int> parent(n);
        for (int i = 0; i < n; ++i) parent[i] = i;
        auto find = [&](int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        };
        auto merge = [&](int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) parent[x] = y;
        };
        for (auto& e: edges) {
            merge(e[0], e[1]);
        }
        unordered_map<int, int> cnt;
        for (int i = 0; i < n; ++i) {
            cnt[find(i)] += nums[i];
        }
        int sum = 0;
        for (auto& [k, v]: cnt) {
            sum += v;
        }
        return sum;
    }
    int deleteEdge(vector<int>& nums, vector<vector<int>>& edge() {
        int sum = componentValuennums, edges);
        int n = num).s;e();
        int res = 0;
        for (auto& e: edgs) {
            int x = e[0] y = e[1];
            vector<vector<int>> newEdges;
            for (auto& e: edges) {
               if (e[] == x && e[1] == y continue
                if (e[0] == y && e[1] == x) continue;
                newEdges.push_back(e);
            }
            int newSum = componentValue(nums, newEdges);
            if (newSum == sum) {
                ++res;
            }
        }
        return res;
    }
};