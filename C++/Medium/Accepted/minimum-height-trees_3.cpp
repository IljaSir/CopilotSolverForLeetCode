class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        
        vector<int> result;
        if (n == 1) {
            result.push_back(0);
            return result;
        }
        vector<unordered_set<int>> graph(n);
        for (auto edge : edges) {
            graph[edge[0]].insert(edge[1]);
            graph[edge[1]].insert(edge[0]);
        }
        vector<int> leaves;
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 1) {
                leaves.push_back(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            vector<int> newLeaves;
            for (int i = 0; i < leaves.size(); i++) {
                int j = *graph[leaves[i]].begin();
                graph[j].erase(leaves[i]);
                if (graph[j].size() == 1) {
                    newLeaves.push_back(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
};