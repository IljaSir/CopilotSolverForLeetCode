class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        
        vector<string> res;
        unordered_map<string, multiset<string>> m;
        for (auto ticket : tickets) {
            m[ticket[0]].insert(ticket[1]);
        }
        stack<string> s;
        s.push("JFK");
        while (!s.empty()) {
            string t = s.top();
            if (m[t].empty()) {
                res.push_back(t);
                s.pop();
            } else {
                s.push(*m[t].begin());
                m[t].erase(m[t].begin());
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};