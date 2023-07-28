class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        
        std::unordered_map<std::string, std::multiset<std::string>> um;
        for (const auto& ticket : tickets) {
            um[ticket[0]].insert(ticket[1]);
        }
        std::vector<std::string> result;
        std::function<void(std::string)> dfs = [&](std::string airport) {
            while (um[airport].size()) {
                std::string next = *um[airport].begin();
                um[airport].erase(um[airport].begin());
                dfs(next);
            }
            result.push_back(airport);
        };
        dfs("JFK");
        std::reverse(result.begin(), result.end());
        return result;
    }
};