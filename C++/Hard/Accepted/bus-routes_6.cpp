class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        
        if(source == target) return 0;
        unordered_map<int, vector<int>> stops;
        unordered_set<int> visited;
        for(int i = 0; i < routes.size(); i++) {
            for(auto stop : routes[i]) {
                stops[stop].push_back(i);
            }
        }
        queue<int> q;
        q.push(source);
        int step = 0;
        while(!q.empty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int stop = q.front();
                q.pop();
                for(auto bus : stops[stop]) {
                    if(visited.count(bus)) continue;
                    visited.insert(bus);
                    for(auto next_stop : routes[bus]) {
                        if(next_stop == target) return step + 1;
                        q.push(next_stop);
                    }
                }
            }
            step++;
        }
        return -1;
    }
};