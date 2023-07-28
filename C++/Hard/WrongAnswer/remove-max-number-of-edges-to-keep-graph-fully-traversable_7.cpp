class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n + 1);
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
        }
        int cnt = n;
        int res = 0;
        for (auto& e : edges) {
            if (e[0] == 3) {
                if (unionSet(e[1], e[2], parent)) {
                    --cnt;
                } else {
                    ++res;
                }
            }
        }
        vector<int> parent1(parent);
        vector<int> parent2(parent);
        int cnt1 = cnt;
        int cnt2 = cnt;
        for (auto& e : edges) {
            if (e[0] == 1) {
                if (unionSet(e[1], e[2], parent1)) {
                    --cnt1;
                }
            } else if (e[0] == 2) {
                if (unionSet(e[1], e[2], parent2)) {
                    --cnt2;
                }
            }
        }
        if (cnt1 != 1 || cnt2 != 1) {
            return -1;
        }
        return res;
    }
    int find(int x, vector<int>& parent) {
        if (x != parent[x]) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    bool unionSet(int x, int y, vector<int>& parent) {
        int rx = find(x, parent);
        int ry = find(y, parent);
        if (rx == ry) {
            return false;
        }
        parent[rx] = ry;
        return true;
    }
};