class Solution {
public:
    int numSquarefulPerms(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> graph(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                int sq = sqrt(sum);
                if (sq * sq == sum) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        vector<int> visited(n, 0);
        unordered_map<int, int> count;
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            count[nums[i]]--;
            visited[i] = 1;
            ans += dfs(graph, visited, nums, i, n - 1);
            visited[i] = 0;
            count[nums[i]]++;
        }
        return ans;
    }
    int dfs(vector<vector<int>>& graph, vector<int>& visited, vector<int>& nums, int cur, int left) {
        if (left == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (visited[i] || graph[cur][i] == 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            count[nums[i]]--;
            visited[i] = 1;
            ans += dfs(graph, visited, nums, i, left - 1);
            visited[i] = 0;
            count[nums[i]]++;
        }
        return ans;
    }
};