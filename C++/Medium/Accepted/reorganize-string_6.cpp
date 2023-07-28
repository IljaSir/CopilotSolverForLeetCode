class Solution {
public:
    string reorganizeString(string s) {
        
        int n = s.size();
        unordered_map<char, int> mp;
        for (char c : s) ++mp[c];
        priority_queue<pair<int, char>> pq;
        for (auto& p : mp) pq.push({p.second, p.first});
        string res;
        while (!pq.empty()) {
            auto t1 = pq.top(); pq.pop();
            if (res.size() == 0 || res.back() != t1.second) {
                res += t1.second;
                if (--t1.first > 0) pq.push(t1);
            } else {
                if (pq.empty()) return "";
                auto t2 = pq.top(); pq.pop();
                res += t2.second;
                if (--t2.first > 0) pq.push(t2);
                pq.push(t1);
            }
        }
        return res;
    }
};