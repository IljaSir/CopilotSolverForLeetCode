class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        
        map<string, multiset<string>> adj;
        for (auto& t : tickets) {
            adj[t[0]].insert(t[1]);
        }
        vector<string> res;
        stack<string> stk;
        stk.push("JFK");
        while (!stk.empty()) {
            string t = stk.top();
            if (adj[t].empty()) {
                res.push_back(t);
                stk.pop();
            } else {
                auto it = adj[t].begin();
                stk.push(*it);
                adj[t].erase(it);
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};