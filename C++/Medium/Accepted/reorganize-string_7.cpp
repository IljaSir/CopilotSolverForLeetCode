class Solution {
public:
    string reorganizeString(string s) {
        
        unordered_map<char, int> counts;
        for (char c : s) {
            counts[c]++;
        }
        
        priority_queue<pair<int, char>> pq;
        for (auto [c, n] : counts) {
            pq.push({n, c});
        }
        
        string ans;
        while (!pq.empty()) {
            auto [n1, c1] = pq.top(); pq.pop();
            if (ans.empty() || ans.back() != c1) {
                ans.push_back(c1);
                if (--n1) {
                    pq.push({n1, c1});
                }
            } else {
                if (pq.empty()) {
                    return "";
                }
                auto [n2, c2] = pq.top(); pq.pop();
                ans.push_back(c2);
                if (--n2) {
                    pq.push({n2, c2});
                }
                pq.push({n1, c1});
            }
        }
        
        return ans;
    }
};