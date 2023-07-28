class Solution {
public:
    vector<int> rearrangeBarcodes(vector<int>& barcodes) {
        
        unordered_map<int, int> m;
        for (auto i : barcodes) m[i]++;
        priority_queue<pair<int, int>> pq;
        for (auto i : m) pq.push({i.second, i.first});
        vector<int> res;
        while (pq.size() > 1) {
            auto a = pq.top(); pq.pop();
            auto b = pq.top(); pq.pop();
            res.push_back(a.second); res.push_back(b.second);
            if (--a.first) pq.push(a);
            if (--b.first) pq.push(b);
        }
        if (pq.size()) res.push_back(pq.top().second);
        return res;
    }
};