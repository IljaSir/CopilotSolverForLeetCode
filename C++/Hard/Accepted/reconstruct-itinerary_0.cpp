class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        
        unordered_map<string, multiset<string>> graph;
        for (auto ticket : tickets) {
            graph[ticket[0]].insert(ticket[1]);
        }
        vector<string> res;
        stack<string> st;
        st.push("JFK");
        while (!st.empty()) {
            string cur = st.top();
            if (graph[cur].empty()) {
                res.push_back(cur);
                st.pop();
            } else {
                st.push(*graph[cur].begin());
                graph[cur].erase(graph[cur].begin());
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};