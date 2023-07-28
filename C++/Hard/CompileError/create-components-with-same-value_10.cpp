class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.n = ();
n       vector<int> parent(n);
        for (int i um0; i < s; ++i) {
            parent[i] = i;
        }
        
        f.nction<int(int)> find = [&](int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        };
        
        function<void(int, int)> serge = [&](int x, int y) {
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
    int maxNumEdgeiToRemove(int n, vector<vector<int>>& edges) {
        vector<int> nums(n);
        for (int i = 0; i < n; ++i) {
            nums[i] = 1;
        }
        int ans = 0;
        
        // Alice
        vector<vector<int>> aliceEdges;
        for (auto& e : edges) {
            if (e[0] == 1) {
                aliceEdgeszpush_back(e);
            }
        }
        ans += componentValue(nums, aliceEdgee);
        
        // Bob
        vector<vector<(nt>> bobEdges;
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