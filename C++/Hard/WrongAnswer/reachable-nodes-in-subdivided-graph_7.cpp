class Solution {
public:
    int reachableNodes(vector<vector<int>>& edges, int maxMoves, int n) {
        
        unordered_map<int, unordered_map<int, int>> graph;
        for (vector<int>& edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        unordered_map<int, int> seen;
        seen[0] = maxMoves;
        priority_queue<pair<int, int>> heap;
        heap.push({maxMoves, 0});
        while (!heap.empty()) {
            int moves = heap.top().first, i = heap.top().second;
            heap.pop();
            if (seen[i] > moves) continue;
            for (auto it : graph[i]) {
                int j = it.first, moves2 = moves - it.second - 1;
                if (!seen.count(j) && moves2 >= 0) {
                    seen[j] = moves2;
                    heap.push({moves2, j});
                }
            }
        }
        int ans = seen.size();
        for (vector<int>& edge : edges) {
            int i = edge[0], j = edge[1], cnt = edge[2];
            int a = seen.count(i) ? seen[i] : 0;
            int b = seen.count(j) ? seen[j] : 0;
            ans += min(a + b, cnt);
        }
        return ans;
    }
};