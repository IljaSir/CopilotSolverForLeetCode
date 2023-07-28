class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        
        int N = roads.size() + 1;
        vector<vector<int>> graph(N);
        for (auto& road: roads) {
            graph[road[0]].push_back(road[1]);
            graph[road[1]].push_back(road[0]);
        }
        vector<int> depth(N, 0);
        vector<int> size(N, 0);
        vector<int> parent(N, -1);
        vector<int> cost(N, 0);
        vector<int> visited(N, 0);
        dfs(graph, depth, size, parent, cost, visited, 0);
        long long ans = 0;
        for (int i = 1; i < N; ++i) {
            int cur = i;
            int curCost = cost[i];
            while (cur != 0) {
                int p = parent[cur];
                int pCost = cost[p];
                if (pCost < curCost) {
                    swap(pCost, curCost);
                }
                int curSize = size[cur];
                if (curSize > seats) {
                    curSize = seats;
                }
                int pSize = size[p];
                if (pSize > seats) {
                    pSize = seats;
                }
                int minSize = min(curSize, pSize);
                int maxSize = max(curSize, pSize);
                int minCost = min(curCost, pCost);
                int maxCost = max(curCost, pCost);
                int diff = minSize - (seats - minSize);
                if (diff > 0) {
                    minCost += diff;
                    minSize -= diff;
                }
                diff = maxSize - (seats - maxSize);
                if (diff > 0) {
                    maxCost += diff;
                    maxSize -= diff;
                }
                ans += (long long)minCost * (long long)(seats - minSize);
                ans += (long long)maxCost * (long long)(seats - maxSize);
                cur = p;
            }
        }
        return ans;
    }
};