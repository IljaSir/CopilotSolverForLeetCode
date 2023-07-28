class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        
        vector<string> res;
        unordered_map<string, priority_queue<string, vector<string>, greater<string>>> mp;
        for (auto& ticket : tickets) {
            mp[ticket[0]].push(ticket[1]);
        }
        stack<string> st;
        st.push("JFK");
        while (!st.empty()) {
            string top = st.top();
            if (mp[top].empty()) {
                res.push_back(top);
                st.pop();
            } else {
                st.push(mp[top].top());
                mp[top].pop();
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};