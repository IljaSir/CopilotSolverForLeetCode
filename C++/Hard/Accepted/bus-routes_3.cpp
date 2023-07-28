class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        
        if (source == target) return 0;
        unordered_map<int, vector<int>> stops;
        for (int i = 0; i < routes.size(); i++) {
            for (auto stop : routes[i]) {
                stops[stop].push_back(i);
            }
        }
        unordered_set<int> seen;
        queue<int> q;
        q.push(source);
        int steps = 0;
        while (!q.empty()) {
            steps++;
            int size = q.size();
            while (size--) {
                int curr = q.front();
                q.pop();
                for (auto bus : stops[curr]) {
                    if (seen.count(bus)) continue;
                    seen.insert(bus);
                    for (auto next : routes[bus]) {
                        if (next == target) return steps;
                        q.push(next);
                    }
                }
            }
        }
        return -1;
    }
};