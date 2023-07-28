class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<int> parent(n, 0);
        vector<int> value(n, 0);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            value[i] = nums[i];
        }
        for (auto& edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int pa = findParent(a, parent);
            int pb = findParent(b, parent);
            if (pa != pb) {
                parent[pa] = pb;
                value[pb] += value[pa];
            }
        }
        return value[findParent(0, parent)];
    }
    int findParent(int a, vector<int>& parent) {
        if (parent[a] != a) {
            parent[a] = findParent(parent[a], parent);
        }
        return parent[a];
    }
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        vector<int> nums(n, 1);
        int ans = 0;
        int value = componentValue(nums, edges);
        vector<vector<int>> newEdges;
        for (auto& edge : edges) {
            if (edge[0] == 3) {
                newEdges.push_back({edge[1] - 1, edge[2] - 1});
            }
        }
        int value2 = componentValue(nums, newEdges);
        if (value != value2) {
            return -1;
        }
        for (auto& edge : edges) {
            if (edge[0] == 3) {
                continue;
            }
            int a = edge[1] - 1;
            int b = edge[2] - 1;
            int pa = findParent(a, nums);
            int pb = findParent(b, nums);
            if (pa != pb) {
                nums[pa] = pb;
            } else {
                ++ans;
            }
        }
        return ans;
    }
};