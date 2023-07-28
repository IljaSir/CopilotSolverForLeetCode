class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        
        unordered_map<string, multiset<string>> m;
        for (auto& t : tickets) {
            m[t[0]].insert(t[1]);
        }
        vector<string> res;
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
        return vector<string>(res.rbegin(), res.rend());
    }
};