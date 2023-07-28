class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<int> parent(n);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        function<int(int)> find = [&](int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        };
        
        function<void(int, int)> merge = [&](int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;
            }
        };
        
        vector<int> sum(n);
        for (int i = 0; i < n; ++i) {
            sum[i] = nums[i];
        }
        
        for (auto& e : edges) {
            int x = e[0];
            int y = e[1];
            merge(x, y);
            sum[find(x)] += sum[find(y)];
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == i) {
                ans += sum[i] - nums[i];
            }
        }
        return ans;
    }
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        vector<int> nums(n);
        for (int i = 0; i < n; ++i) {
            nums[i] = 1;
        }
        int ans = 0;
        
        // Alice
        vector<vector<int>> aliceEdges;
        for (auto& e : edges) {
            if (e[0] == 1) {
                aliceEdges.push_back(e);
            }
        }
        ans += componentValue(nums, aliceEdges);
        
        // Bob
        vector<vector<int>> bobEdges;
        for (auto& e : edges) {
            if (e[0] == 2) {
                bobEdges.push_back(e);
            }
        }
        ans += componentValue(nums, bobEdges);
        
        // Common
        vector<vector<int>> commonEdges;
        for (auto& e : edges) {
            if (e[0] == 3) {
                commonEdges.push_back(e);
            }
        }
        ans += componentValue(nums, commonEdges);
        
        // Check
    }
};