class Solution {
public:
    bool gcdSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sorted(nums);
        sort(sorted.begin(), sorted.end());
        vector<vector<int>> g(n);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (gcd(nums[i], nums[j]) > 1) {
                    g[i].push_back(j);
                    g[j].push_back(i);
                }
            }
        }
        vector<bool> visited(n, false);
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, g, visited);
                vector<int> cur;
                for (int j = 0; j < n; ++j) {
                    if (visited[j]) {
                        cur.push_back(nums[j]);
                    }
                }
                sort(cur.begin(), cur.end());
                for (int j = 0; j < n; ++j) {
                    if (visited[j]) {
                        nums[j] = cur[j];
                    }
                }
            }
        }
        return nums == sorted;
    }
};