class Solution {
public:
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        
        unordered_map<int, unordered_map<int, int>> edgeMap;
        unordered_set<int> visited;
        for (auto& edge : edges) {
            edgeMap[edge[0]][edge[1]] = edge[2];
            edgeMap[edge[1]][edge[0]] = edge[2];
        }
        queue<int> q;
        q.push(0);
        int res = 0;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            if (visited.count(node)) continue;
            visited.insert(node);
            res++;
            for (auto& [nextNode, weight] : edgeMap[node]) {
                if (visited.count(nextNode)) continue;
                if (weight > 0) {
                    weight--;
                    edgeMap[nextNode][node]--;
                    q.push(nextNode);
                }
            }
        }
        for (auto& edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];
            int used = min(edgeMap[node1][node2], edgeMap[node2][node1]);
            res += used;
            int remain = weight - used;
            if (visited.count(node1) && visited.count(node2)) {
                res += remain;
            } else if (visited.count(node1) || visited.count(node2)) {
                res += remain;
                if (remain > 0) {
                    for (auto& [nextNode, weight] : edgeMap[node1]) {
                        if (visited.count(nextNode)) continue;
                        if (weight > 0) {
                            weight--;
                            edgeMap[nextNode][node1]--;
                            q.push(nextNode);
                        }
                    }
                    for (auto& [nextNode, weight] : edgeMap[node2]) {
                        if (visited.count(nextNode)) continue;
                        if (weight > 0) {
                            weight--;
                            edgeMap[nextNode][node2]--;
                            q.push(nextNode);
                        }
                    }
                }
            }
        }
        return res;
    }
};