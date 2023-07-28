class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        
        string res = "";
        priority_queue<pair<int, char>> pq;
        if (a > 0) pq.push({a, 'a'});
        if (b > 0) pq.push({b, 'b'});
        if (c > 0) pq.push({c, 'c'});
        while (pq.size() > 1) {
            auto p1 = pq.top(); pq.pop();
            auto p2 = pq.top(); pq.pop();
            if (p1.first > 0) {
                res += p1.second;
                --p1.first;
            }
            if (p2.first > 0) {
                res += p2.second;
                --p2.first;
            }
            pq.push(p1);
            pq.push(p2);
        }
        if (pq.size() == 1) {
            auto p = pq.top(); pq.pop();
            if (p.first > 1) {
                res += p.second;
                --p.first;
            }
            if (p.first > 0) {
                res += p.second;
                --p.first;
            }
        }
        return res;
    }
};