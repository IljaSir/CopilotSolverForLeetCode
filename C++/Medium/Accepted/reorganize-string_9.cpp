class Solution {
public:
    string reorganizeString(string s) {
        
        int n = s.length();
        int count[26] = {0};
        for (char ch : s) count[ch - 'a']++;
        priority_queue<pair<int, char>> pq;
        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) pq.push({count[i], 'a' + i});
        }
        string res;
        while (!pq.empty()) {
            auto p = pq.top(); pq.pop();
            if (res.empty() || res.back() != p.second) {
                res += p.second;
                if (--p.first > 0) pq.push(p);
            } else {
                if (pq.empty()) return "";
                auto q = pq.top(); pq.pop();
                res += q.second;
                if (--q.first > 0) pq.push(q);
                pq.push(p);
            }
        }
        return res;
    }
};