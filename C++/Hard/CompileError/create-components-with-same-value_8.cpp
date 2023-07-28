class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
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
    }
};