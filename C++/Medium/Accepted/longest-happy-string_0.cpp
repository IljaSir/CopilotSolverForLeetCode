class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        
        priority_queue<pair<int, char>> pq;
        if (a) pq.push({a, 'a'});
        if (b) pq.push({b, 'b'});
        if (c) pq.push({c, 'c'});
        string res;
        while (!pq.empty()) {
            auto t = pq.top(); pq.pop();
            if (res.size() >= 2 && res.back() == res[res.size() - 2] && res.back() == t.second) {
                if (pq.empty()) break;
                auto t2 = pq.top(); pq.pop();
                res.push_back(t2.second);
                if (--t2.first > 0) pq.push(t2);
                pq.push(t);
            } else {
                res.push_back(t.second);
                if (--t.first > 0) pq.push(t);
            }
        }
        return res;
    }
};