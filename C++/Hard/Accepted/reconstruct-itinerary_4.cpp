class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        
        unordered_map<string, multiset<string>> graph;
        for (auto ticket : tickets) {
            graph[ticket[0]].insert(ticket[1]);
        }
        vector<string> ans;
        stack<string> st;
        st.push("JFK");
        while (!st.empty()) {
            string top = st.top();
            if (graph[top].empty()) {
                ans.push_back(top);
                st.pop();
            } else {
                st.push(*graph[top].begin());
                graph[top].erase(graph[top].begin());
            }
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};