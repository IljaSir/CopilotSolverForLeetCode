class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        
        int row = heights.size();
        int column = heights[0].size();
        vector<int> distance(row * column, INT_MAX);
        distance[0] = 0;
        vector<vector<int>> direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 0});
        while (!pq.empty()) {
            auto top = pq.top();
            pq.pop();
            int x = top.second / column;
            int y = top.second % column;
            for (auto &d : direction) {
                int nextX = x + d[0];
                int nextY = y + d[1];
                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= column)
                    continue;
                int nextIndex = nextX * column + nextY;
                int nextDistance = max(distance[top.second], abs(heights[x][y] - heights[nextX][nextY]));
                if (nextDistance < distance[nextIndex]) {
                    distance[nextIndex] = nextDistance;
                    pq.push({nextDistance, nextIndex});
                }
            }
        }
        return distance[row * column - 1];
    }
};