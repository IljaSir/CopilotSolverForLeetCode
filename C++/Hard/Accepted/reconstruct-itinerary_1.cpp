class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        
        unordered_map<string, multiset<string>> graph;
        for (auto ticket : tickets) {
            graph[ticket[0]].insert(ticket[1]);
        }
        vector<string> res;
        stack<string> s;
        s.push("JFK");
        while (!s.empty()) {
            string top = s.top();
            if (graph[top].empty()) {
                res.push_back(top);
                s.pop();
            } else {
                s.push(*graph[top].begin());
                graph[top].erase(graph[top].begin());
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};