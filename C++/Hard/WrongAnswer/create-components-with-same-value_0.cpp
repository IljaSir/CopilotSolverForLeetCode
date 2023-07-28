class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<int> parent(n);
        vector<int> sum(n);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            sum[i] = nums[i];
        }
        for (auto& e : edges) {
            int x = find(parent, e[0]);
            int y = find(parent, e[1]);
            if (x != y) {
                parent[y] = x;
                sum[x] += sum[y];
            }
        }
        return sum[find(parent, 0)];
    }
    int find(vector<int>& parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    int deleteEdges(vector<int>& nums, vector<vector<int>>& edges) {
        int n = nums.size();
        int total = accumulate(nums.begin(), nums.end(), 0);
        int component = componentValue(nums, edges);
        if (total % component != 0) {
            return -1;
        }
        int target = total / component;
        vector<int> parent(n);
        vector<int> sum(n);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            sum[i] = nums[i];
        }
        int res = 0;
        for (auto& e : edges) {
            int x = find(parent, e[0]);
            int y = find(parent, e[1]);
            if (x != y) {
                if (sum[x] + sum[y] == target) {
                    parent[y] = x;
                    sum[x] += sum[y];
                } else {
                    ++res;
                }
            }
        }
        return res;
    }
};