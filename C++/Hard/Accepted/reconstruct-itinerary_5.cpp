class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        
        unordered_map<string, multiset<string>> m;
        vector<string> res;
        for (auto& ticket : tickets) {
            m[ticket[0]].insert(ticket[1]);
        }
        stack<string> s;
        s.push("JFK");
        while (!s.empty()) {
            string cur = s.top();
            if (m[cur].empty()) {
                res.push_back(cur);
                s.pop();
            } else {
                s.push(*m[cur].begin());
                m[cur].erase(m[cur].begin());
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};