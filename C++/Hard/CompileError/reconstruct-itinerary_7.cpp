class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        
        unordered_map<string, multiset<string>> graph;
        for(auto& ticket : tickets) {
            graph[ticket[0]].insert(ticket[1]);
        }
        vector<string> result;
        dfs(graph, "JFK", result);
        reverse(result.begin(), result.end());
        return result;
    }
};