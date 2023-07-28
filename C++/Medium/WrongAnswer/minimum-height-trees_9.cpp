class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        
        // 1. build graph
        vector<vector<int>> graph(n, vector<int>());
        for (auto &e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        
        // 2. find leaves
        vector<int> leaves;
        for (int i = 0; i < graph.size(); i++) {
            if (graph[i].size() == 1) {
                leaves.push_back(i);
            }
        }
        
        // 3. remove leaves
        while (n > 2) {
            n -= leaves.size();
            vector<int> newLeaves;
            for (int i = 0; i < leaves.size(); i++) {
                int j = graph[leaves[i]][0];
                graph[j].erase(find(graph[j].begin(), graph[j].end(), leaves[i]));
                if (graph[j].size() == 1) {
                    newLeaves.push_back(j);
                }
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
};