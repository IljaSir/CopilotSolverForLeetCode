class Solution {
public:
    int numSquarefulPerms(vector<int>& nums) {
        
        int N = nums.size();
        vector<vector<int>> graph(100, vector<int>());
        vector<int> count(100, 0);
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                int a = nums[i], b = nums[j];
                int c = (int) sqrt(a + b);
                if (c * c == a + b) {
                    graph[a].push_back(b);
                    graph[b].push_back(a);
                }
            }
            count[nums[i]]++;
        }
        int ans = 0;
        vector<int> path;
        vector<int> visited(100, 0);
        for (int i = 0; i < 100; ++i) {
            if (count[i] > 0) {
                dfs(i, graph, count, visited, path, ans);
            }
        }
        return ans;
    }
    
    void dfs(int u, vector<vector<int>>& graph, vector<int>& count, vector<int>& visited, vector<int>& path, int& ans) {
        path.push_back(u);
        visited[u]++;
        count[u]--;
        if (path.size() == count.size()) {
            ans++;
        } else {
            for (int v : graph[u]) {
                if (count[v] > 0 && (visited[v] < 2 || (path.size() == count.size() - 1 && v == path[0]))) {
                    dfs(v, graph, count, visited, path, ans);
                }
            }
        }
        visited[u]--;
        count[u]++;
        path.pop_back();
    }
};