class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size()
        unordered_map<int, int> m;
        for (int i = 0; i < n; ++i) {
            m[i] = nums[i];
        }
        for (const auto& e : edges) {
            int u = e[0];
            int v = e[1];
            m[u] += m[v];
            m.erase(v);
        }
        return m.begin()->second;
    }
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        int ans = 0;
        vector<int> nums(n, 0);
        for (int i = 0; i < n; ++i) {
            nums[i] = 1;
        }
        int a = componentValue(nums, edges);
        vector<int> nums1(nums);
        int b = componentValue(nums1, edges);
        if (a != b) {
            return -1;
        }
        int c = 0;
        for (const auto& e : edges) {
            int u = e[0];
            int v = e[1];
            if (u == 3) {
                if (nums[u - 1] != nums[v - 1]) {
                    ++c;
                    nums[u - 1] += nums[v - 1];
                    nums[v - 1] = 0;
                } else {
                    ++ans;
                }
            }
        }
        for (const auto& e : edges) {
            int u = e[0];
            int v = e[1];
            if (u == 1) {
                if (nums[u - 1] != nums[v - 1]) {
                    ++c;
                    nums[u - 1] += nums[v - 1];
                    nums[v - 1] = 0;
                } else {
                    ++ans;
                }
            }
        }
        for (const auto& e : edges) {
            int u = e[0];
            int v = e[1];
            if (u == 2) {
                if (nums[u - 1] != nums[v - 1]) {
                    ++c;
                    nums[u - 1] += nums[v - 1];
                    nums[v - 1] = 0;
                } else {
                    ++ans;
                }
            }
        }
        return c == n -
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